package com.mkahn.mkahn.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mkahn.mkahn.controller.UserController;
import com.mkahn.mkahn.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
@RequiredArgsConstructor
public class JwtInterceptor implements HandlerInterceptor {
    private static final Logger logger = LogManager.getLogger(UserController.class);

    private final JwtService jwtService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("===============================================");
        logger.debug("==================== BEGIN ====================");
        logger.debug("Request URI ===> " + request.getRequestURI());

        String header = request.getHeader("Authorization");

        // HTTP Method 가 OPTION 일 경우에는 무조건 true, 참true
        if ("OPTIONS".equals(request.getMethod())) {
            return true;
        }

        if( header == null || !header.startsWith("Bearer ")){
            response.setStatus(401);
            return false;
        }

        if(jwtService.isValidate(header) != null){
            return true;
        }else{
            response.setStatus(403);
            return false;
        }

    }

//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        logger.debug("==================== END ======================");
//        logger.debug("===============================================");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//    }

}