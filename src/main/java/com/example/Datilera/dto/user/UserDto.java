package com.example.Datilera.dto.user;

import com.example.Datilera.domain.enums.RoleEnumUser;

public record UserDto(
    Long id_user,
    String username,
    String email,
    RoleEnumUser role) {

}