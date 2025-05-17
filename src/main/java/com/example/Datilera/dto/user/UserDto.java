package com.example.datilera.dto.user;

import com.example.datilera.domain.enums.RoleEnumUser;

public record UserDto(
    Long id_user,
    String username,
    String email,
    RoleEnumUser role) {

}