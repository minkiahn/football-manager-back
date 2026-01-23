package com.mkahn.mkahn.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlaceDto {
    private Long id;
    private Long teamId;
    private String name;
}