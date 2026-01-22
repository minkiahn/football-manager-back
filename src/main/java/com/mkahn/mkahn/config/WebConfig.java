package com.mkahn.mkahn.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.resource.PathResourceResolver;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {


    private final JwtInterceptor jwtInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //List<String> imageFolders = Arrays.asList("alloc","etc")
        List<String> imageFolders = Collections.singletonList("alloc");

        for (String imageFolder : imageFolders) {
            registry.addResourceHandler("/static/image/" + imageFolder + "/**")
                    .setCachePeriod(3600)
                    .resourceChain(true)
                    .addResolver(new PathResourceResolver());
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATHS);
    }



    //아래에 기재한 경로는 접속가능하게 허용
    private static final String[] EXCLUDE_PATHS = {
            "/api/user/signUp"
            , "/api/user/signIn"
            , "/api/user/nickNameCheck"
            , "/api/user/emailCheck"
            , "/favicon.ico"
    };


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8087", "http://footballposition.com")  // 허용할 주소 및 포트
                .allowedMethods(HttpMethod.GET.name()
                        , HttpMethod.HEAD.name()
                        , HttpMethod.POST.name()
                        , HttpMethod.PUT.name()
                        , HttpMethod.DELETE.name()
                        , HttpMethod.PATCH.name()
                        , HttpMethod.OPTIONS.name());
    }

}
