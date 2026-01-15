package com.mkahn.mkahn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuaterDto {

    private Long id;

    private Long playerId;   // Players.id

    private Integer quarterNo;
    private String status;

    private Integer pointX;
    private Integer pointY;

    private String playerName;
    private String playerPosition1;
    private String playerPosition2;
    private String playerTeamABType;
}