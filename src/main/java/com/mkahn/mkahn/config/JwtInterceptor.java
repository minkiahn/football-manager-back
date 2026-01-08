package com.mkahn.mkahn.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mkahn.mkahn.controller.UserController;
import com.mkahn.mkahn.dto.UserDto;
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
    public boolean preHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler
    ) throws Exception {

        logger.debug("===============================================");
        logger.debug("==================== BEGIN ====================");
        logger.debug("Request URI ===> {}", request.getRequestURI());

        // CORS preflight 요청은 통과
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }

        UserDto user = jwtService.isValidate(header);

        if (user != null) {
            // ⭐ ThreadLocal에 사용자 정보 저장
            UserContext.setUser(user);
            return true;
        } else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
    }

    /**
     * ⭐ 요청 종료 후 반드시 ThreadLocal 초기화
     */
    @Override
    public void afterCompletion(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            Exception ex
    ) {
        UserContext.clear();
        logger.debug("==================== END ======================");
    }
}
