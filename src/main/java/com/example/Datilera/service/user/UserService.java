package com.example.Datilera.service.user;

import com.example.Datilera.domain.User;
import com.example.Datilera.dto.user.UserRegisterDto;

public interface UserService {
    User createUser(UserRegisterDto userRegisterDto);
    User getLoggingUser();
    User getUserById(Long id_user);
}