package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.board.Board;
import com.mkahn.mkahn.dto.BoardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BoardMapper {
    @Mapping(source = "writer.userId", target = "writerId")
    @Mapping(source = "writer.nickName", target = "writerNickName")
    @Mapping(source = "regDt", target = "regDt")
    @Mapping(source = "updateDt", target = "updateDt")
    BoardDto convertToDto(Board board);

    @Mapping(source = "writer.userId", target = "writerId")
    @Mapping(source = "writer.nickName", target = "writerNickName")
    List<BoardDto> convertToDtoList(List<Board> boardList);
    @Mapping(source = "writerId", target = "writer.userId")
    Board convertToEntity(BoardDto boardDto);


}
