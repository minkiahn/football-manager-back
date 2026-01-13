package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.PlayersDto;
import com.mkahn.mkahn.service.PlayersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayersController {

    private final PlayersService playersService;

    @GetMapping("/game/{gameId}")
    public List<PlayersDto> list(@PathVariable Long gameId) {
        return playersService.list(gameId);
    }

    @PostMapping
    public PlayersDto add(@RequestBody PlayersDto dto) {
        return playersService.addPlayer(dto);
    }

    @PatchMapping("/{playerId}")
    public PlayersDto updateResult(@RequestBody PlayersDto dto, @PathVariable Long playerId) {
        return playersService.updateResult(dto, playerId);
    }

    @DeleteMapping("/{playerId}")
    public void delete(@PathVariable Long playerId) {
        playersService.delete(playerId);
    }
}

