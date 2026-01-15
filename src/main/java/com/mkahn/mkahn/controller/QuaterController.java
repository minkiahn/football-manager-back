package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.QuaterDto;
import com.mkahn.mkahn.service.QuaterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quaters")
@RequiredArgsConstructor
public class QuaterController {

    private final QuaterService quaterService;

    /**
     * 플레이어별 쿼터 목록 조회
     */
    @GetMapping("/game/{gameId}")
    public List<QuaterDto> list(@PathVariable Long gameId) {
        return quaterService.listByGame(gameId);
    }

    /**
     * 쿼터 정보 수정
     */
    @PutMapping("/{quaterId}")
    public QuaterDto update(
            @PathVariable Long quaterId,
            @RequestBody QuaterDto dto
    ) {
        return quaterService.update(quaterId, dto);
    }
}
