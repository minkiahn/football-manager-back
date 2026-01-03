package com.mkahn.mkahn.dto;

import com.mkahn.mkahn.domain.team.Team;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDto {
    private Long id;
    private Long teamId;
    private Long writerId;
    private String matchDt;
    private String time;
    private String place;
    private String type;
    private String playersCountType;
    private Integer teamAScore;
    private Integer teamBScore;
    private String vsName;
    private String status;

}
