package com.mkahn.mkahn.dto;

import com.mkahn.mkahn.domain.team.Team;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserDto {
    private Long userId;
    private Long teamId;
    private String userEmail;
    private String nickName;
    private String pwd;

    private String status;
    private String token;

    private LocalDateTime regDt;
    private LocalDateTime updateDt;

    private String teamName;
}
