package com.example.datilera.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.datilera.domain.User;
import com.example.datilera.dto.user.UserDto;
import com.example.datilera.dto.user.UserRegisterDto;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id_user", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "authorities", ignore = true)
    User userRegisterDtoToUser(UserRegisterDto userRegisterDto);
    UserDto userToUserDto(User user);
}