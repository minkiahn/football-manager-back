package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.game.Game;
import com.mkahn.mkahn.dto.GameDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GameMapper {

    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "writer.userId", target = "writerId")
    GameDto convertToDto(Game game);

    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "writer.userId", target = "writerId")
    List<GameDto> convertToDtoList(List<Game> gameList);

    @Mapping(source = "teamId", target = "team.id")
    @Mapping(source = "writerId", target = "writer.userId")
    Game convertToEntity(GameDto gameDto);
}
