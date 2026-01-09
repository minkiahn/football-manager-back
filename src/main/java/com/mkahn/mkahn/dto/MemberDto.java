package com.mkahn.mkahn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberDto {

    private Long id;
    private Long teamId;

    private String name;
    private String position1;
    private String position2;

    private String status;
}