package com.mkahn.mkahn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttendStatDto {
    private Integer ranking;
    private String name;
    private Integer attendGameCnt;
    private Integer totalGameCnt;
    private Integer attendRatio;
}