package com.mkahn.mkahn.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttackStatDto {
    private Integer ranking;
    private String name;
    private Integer goal;
    private Integer assist;
    private Integer attackPoint;
}