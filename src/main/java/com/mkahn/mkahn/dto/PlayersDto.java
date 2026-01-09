package com.mkahn.mkahn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlayersDto {

    private Long id;

    private Long gameId;
    private Long teamId;
    private Long writerId;

    private Long memberId;     // null → 용병
    private String name;
    private String position1;
    private String position2;

    private String teamABType;
    private Integer goal;
    private Integer assist;
}