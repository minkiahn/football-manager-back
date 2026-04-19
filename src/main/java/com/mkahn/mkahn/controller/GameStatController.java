package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.AttackStatDto;
import com.mkahn.mkahn.dto.AttendStatDto;
import com.mkahn.mkahn.dto.PointStatDto;
import com.mkahn.mkahn.service.GameStatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/game/stats")
@RequiredArgsConstructor
public class GameStatController {

    private final GameStatService service;

    @GetMapping("/attend")
    public List<AttendStatDto> attend(@RequestParam int year, @RequestParam String month) {
        return service.attend(year, month);
    }

    @GetMapping("/point")
    public List<PointStatDto> point(@RequestParam int year, @RequestParam String month) {
        return service.point(year, month);
    }

    @GetMapping("/attack")
    public List<AttackStatDto> attack(@RequestParam int year, @RequestParam String month) {
        return service.attack(year, month);
    }
}