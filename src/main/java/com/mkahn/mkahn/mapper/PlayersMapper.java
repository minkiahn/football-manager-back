package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.players.Players;
import com.mkahn.mkahn.dto.PlayersDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlayersMapper {

    /* Entity → DTO */
    @Mapping(source = "game.id", target = "gameId")
    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "writer.userId", target = "writerId")
    PlayersDto toDto(Players players);

    @Mapping(source = "game.id", target = "gameId")
    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "writer.userId", target = "writerId")
    List<PlayersDto> toDtoList(List<Players> playersList);

    /* DTO → Entity */
    @Mapping(source = "gameId", target = "game.id")
    @Mapping(source = "teamId", target = "team.id")
    @Mapping(source = "writerId", target = "writer.userId")
    Players toEntity(PlayersDto dto);
}
