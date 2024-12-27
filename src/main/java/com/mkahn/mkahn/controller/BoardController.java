package com.mkahn.mkahn.controller;

import com.mkahn.mkahn.dto.BoardDto;
import com.mkahn.mkahn.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
@Log4j2
public class BoardController {
    private static final Logger logger = LogManager.getLogger(BoardController.class);

    private final BoardService boardService;

    @GetMapping(path = "/list")
    public Object getList() {
        return boardService.list();
    }

    @PostMapping
    public BoardDto registBoard(@RequestBody BoardDto boardDto){
        return boardService.save(boardDto);
    }

    @PatchMapping("/{boardNo}")
    public BoardDto updateBoard(@RequestBody BoardDto boardDto, @PathVariable Long boardNo) throws Exception {
        return boardService.update(boardDto, boardNo);
    }

    @DeleteMapping("/{boardNo}")
    public boolean deleteBoard(@PathVariable Long boardNo){
        try {
            boardService.delete(boardNo);
        }catch(Exception e){
            return false;
        }
        return true;
    }
}
