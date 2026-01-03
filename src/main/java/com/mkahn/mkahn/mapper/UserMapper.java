package com.mkahn.mkahn.mapper;

import com.mkahn.mkahn.domain.board.Board;
import com.mkahn.mkahn.domain.user.User;
import com.mkahn.mkahn.dto.BoardDto;
import com.mkahn.mkahn.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "userEmail", target = "userEmail")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "pwd", target = "pwd")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "regDt", target = "regDt")
    @Mapping(source = "updateDt", target = "updateDt")
    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "team.name", target = "teamName")
    UserDto convertToDto(User user);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "userEmail", target = "userEmail")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "pwd", target = "pwd")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "regDt", target = "regDt")
    @Mapping(source = "updateDt", target = "updateDt")
    @Mapping(source = "team.id", target = "teamId")
    @Mapping(source = "team.name", target = "teamName")
    List<UserDto> convertToDtoList(List<User> boardList);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "userEmail", target = "userEmail")
    @Mapping(source = "nickName", target = "nickName")
    @Mapping(source = "pwd", target = "pwd")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "token", target = "token")
    @Mapping(source = "teamId", target = "team.id")
    User convertToEntity(UserDto userDto);


}
