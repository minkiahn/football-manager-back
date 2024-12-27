package com.mkahn.mkahn.service;

import com.mkahn.mkahn.domain.board.Board;
import com.mkahn.mkahn.domain.board.BoardRepository;
import com.mkahn.mkahn.dto.BoardDto;
import com.mkahn.mkahn.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardMapper boardMapper;

    public List<BoardDto> list() {
        Sort sort = Sort.by(Sort.Direction.DESC, "regDt");
        return boardMapper.convertToDtoList(boardRepository.findAll(sort));
    }
    @Transactional
    public BoardDto save(BoardDto boardDto) {
        Board boardEntity = boardMapper.convertToEntity(boardDto);
        BoardDto boardDtoResult = boardMapper.convertToDto(boardRepository.save(boardEntity));
        return boardDtoResult;
    }

    @Transactional
    public BoardDto update(BoardDto boardDto, Long boardNo) throws Exception {
        Board board = Optional.of(boardRepository.findById(boardNo)).get().orElseThrow(() -> new Exception());
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContent());
        return boardMapper.convertToDto(board);
    }

    @Transactional
    public void delete(Long boardNo){
        boardRepository.deleteById(boardNo);
    }
}
