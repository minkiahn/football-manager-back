package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.quater.Quater;
import com.mkahn.mkahn.dto.QuaterDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface QuaterMapper {

    /* Entity → DTO */
    @Mapping(source = "players.id", target = "playerId")
    @Mapping(source = "players.name", target = "playerName")
    @Mapping(source = "players.position1", target = "playerPosition1")
    @Mapping(source = "players.position2", target = "playerPosition2")
    @Mapping(source = "players.teamABType", target = "playerTeamABType")
    @Mapping(source = "players.memberId", target = "playerMemberId")
    QuaterDto toDto(Quater quarter);

    @Mapping(source = "players.id", target = "playerId")
    @Mapping(source = "players.name", target = "playerName")
    @Mapping(source = "players.position1", target = "playerPosition1")
    @Mapping(source = "players.position2", target = "playerPosition2")
    @Mapping(source = "players.teamABType", target = "playerTeamABType")
    @Mapping(source = "players.memberId", target = "playerMemberId")
    List<QuaterDto> toDtoList(List<Quater> quarters);

    /* DTO → Entity */
    @Mapping(source = "playerId", target = "players.id")
    Quater toEntity(QuaterDto dto);
}
