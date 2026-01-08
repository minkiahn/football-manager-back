package com.mkahn.mkahn.service;


import com.mkahn.mkahn.dto.UserDto;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * Class Name : JwtServiceImpl.java
 * Description : 토큰 서비스 Class
 * Modification Information
 *   2020.10.29 마이그레이션 -> 토큰 검증, 생성 및 갱신 by 곽하민
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class JwtService {

    private static final String SALT = "mkahn$00";

    @Value("${token.access}")
    private Integer accessExpiration;

    @Value("${token.refresh}")
    private Long refreshExpiration;

    private static final String USER_ID = "userId";
    private static final String REG_DATE = "regDate";
    private static final String NICK_NAME = "nickName";
    private static final String TEAM_ID = "teamId";
    private static final String LAST_LOGIN_DATE = "lastLoginDate";

    public String createAccessToken(long userId, String userNm, Long teamId) {
        String accessJwtToken = Jwts.builder().setHeaderParam("type","JWT")
                .setHeaderParam(REG_DATE,System.currentTimeMillis())
                .setExpiration(new Date(System.currentTimeMillis() + accessExpiration))
                .claim(USER_ID, userId)
                .claim(NICK_NAME, userNm)
                .claim(TEAM_ID, teamId)
                .signWith(SignatureAlgorithm.HS256, this.generateKey()).compact();
        log.info("---------------------------Create Access Token----------------------------------");
        log.info("AccessJwtToken : {}",accessJwtToken);
        return accessJwtToken;
    }

    public String createRefreshToken(long userId, String userNm) {
        String refreshJwtToken = Jwts.builder().setHeaderParam("type", "JWT")
                .setHeaderParam(REG_DATE, System.currentTimeMillis())
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .claim(USER_ID, userId)
                .claim(NICK_NAME, userNm)
                .signWith(SignatureAlgorithm.HS256, this.generateKey()).compact();
        log.info("---------------------------Create Refresh Token----------------------------------");
        log.info("RefreshJwtToken : {}",refreshJwtToken);
        return refreshJwtToken;
    }

    public UserDto isValidate(String jwt) throws Exception {
        log.info("--------------------------IS VALIDATE JWT TOKEN----------------------------------");
        if( jwt == null || jwt.isEmpty()) {
            return null;
        } else {
            String token = jwt.substring(7);
            return this.convertAuthDto(token);
        }
     }

    private UserDto convertAuthDto(String jwt) throws Exception {
        log.info("convertAuthDto jwt : {}", jwt);
        Jws<Claims> claims;
        UserDto user = new UserDto();
        try {
            claims = Jwts.parser().setSigningKey(this.generateKey()).parseClaimsJws(jwt);
            Claims claim = claims.getBody();

            long userId = (Integer) claim.get(USER_ID);
            String nickName = (String) claim.get(NICK_NAME);
            long teamId = (Integer) claim.get(TEAM_ID);


            user.setUserId(userId);
            user.setNickName(nickName);
            user.setTeamId(teamId);

            return user;
        }catch (Exception e) {
            log.info("=============================================================");
            log.info(e.toString());
            log.info("=============================================================");
            return null;
        }
    }

    private byte[] generateKey() {
        return DatatypeConverter.parseBase64Binary(JwtService.SALT);
    }


}
