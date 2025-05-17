package com.example.datilera.service.user;

import com.example.datilera.domain.User;
import com.example.datilera.dto.user.UserRegisterDto;

public interface UserService {
    User createUser(UserRegisterDto userRegisterDto);
    User getLoggingUser();
    User getUserById(Long id_user);
}