package com.mkahn.mkahn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PointStatDto {
    private Integer ranking;
    private String name;
    private Integer winCnt;
    private Integer drawCnt;
    private Integer loseCnt;
    private Integer totalPoint;
}
