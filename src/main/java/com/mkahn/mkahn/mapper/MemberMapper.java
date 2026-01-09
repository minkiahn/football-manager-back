package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.member.Member;
import com.mkahn.mkahn.dto.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    @Mapping(source = "team.id", target = "teamId")
    MemberDto toDto(Member member);

    List<MemberDto> toDtoList(List<Member> members);

    @Mapping(source = "teamId", target = "team.id")
    Member toEntity(MemberDto dto);
}
