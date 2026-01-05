package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.BoardDto;
import com.mkahn.mkahn.dto.GameDto;
import com.mkahn.mkahn.service.BoardService;
import com.mkahn.mkahn.service.GameService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor
@Log4j2
public class GameController {
    private static final Logger logger = LogManager.getLogger(GameController.class);

    private final GameService gameService;

    @GetMapping(path = "/list/team/{id}")
    public Object getList(@PathVariable Long id) {
        return gameService.list(id);
    }

    @PostMapping
    public GameDto registGame(@RequestBody GameDto gameDto){
        return gameService.save(gameDto);
    }

    @PatchMapping("/{id}")
    public GameDto updateGame(@RequestBody GameDto gameDto, @PathVariable Long id) throws Exception {
        return gameService.update(gameDto, id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteGame(@PathVariable Long id){
        try {
            gameService.delete(id);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
