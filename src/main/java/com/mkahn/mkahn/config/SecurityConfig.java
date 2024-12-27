package com.mkahn.mkahn.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable() // .csrf() 이 설정은 CSRF 공격을 막기위해 세팅되어있는데 .disable()을 세팅해 놓지 않으면 해당 작업을 수행하기 위한 파라미터가 없다고 에러가 발생하기 때문에 .disable()을 해주도록 한다.
				// 토큰(jwt) 기반으로 rest api 서버 개발시에는 대체로 사용하지 않는것으로 나옴 // https://codeday.me/ko/qa/20190531/677751.html
				.authorizeRequests().antMatchers("/api/**").permitAll() // 인증처리는 JwtInterceptor 에서 처리한다. 향후에 spring-security 를 제대로 사용할 수 있도록 추가 작업을 하자.(지금도 별 문제는 아니라고 생각한다.)
				.anyRequest().authenticated()
				.and()
				.formLogin().disable();

		return http.build();
	}

	@Bean
	public WebSecurityCustomizer webSecurityCustomizer() {
		return web -> web.ignoring().antMatchers("/api/**", "/swagger-ui/**", "/webjars/**", "/swagger-resources/**", "/v2/**");
	}


}