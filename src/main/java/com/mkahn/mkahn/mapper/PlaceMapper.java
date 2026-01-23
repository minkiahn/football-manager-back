package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.place.Place;
import com.mkahn.mkahn.dto.PlaceDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PlaceMapper {

    @Mapping(source = "team.id", target = "teamId")
    PlaceDto toDto(Place place);

    List<PlaceDto> toDtoList(List<Place> places);

    @Mapping(source = "teamId", target = "team.id")
    Place toEntity(PlaceDto dto);
}
