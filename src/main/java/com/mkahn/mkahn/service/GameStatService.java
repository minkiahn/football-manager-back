package com.mkahn.mkahn.service;

import com.mkahn.mkahn.config.UserContext;
import com.mkahn.mkahn.domain.stat.GameStatRepository;
import com.mkahn.mkahn.dto.AttackStatDto;
import com.mkahn.mkahn.dto.AttendStatDto;
import com.mkahn.mkahn.dto.PointStatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameStatService {

    private final GameStatRepository repository;

    public List<AttendStatDto> attend(int year) {
        return repository.attendStats(
                UserContext.getUser().getTeamId(), year);
    }

    public List<PointStatDto> point(int year) {
        return repository.pointStats(
                UserContext.getUser().getTeamId(), year);
    }

    public List<AttackStatDto> attack(int year) {
        return repository.attackStats(
                UserContext.getUser().getTeamId(), year);
    }
}