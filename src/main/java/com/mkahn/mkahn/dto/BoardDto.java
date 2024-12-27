package com.mkahn.mkahn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto{
    private Long boardNo;
    private String title;
    private String content;
    private Long writerId;
    private String writerNickName;
    private String regDt;
    private String updateDt;
}
