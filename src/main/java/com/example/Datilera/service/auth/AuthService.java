package com.example.datilera.service.auth;

import com.example.datilera.dto.auth.AuthResponseDto;
import com.example.datilera.dto.user.UserLoginDto;
import com.example.datilera.dto.user.UserRegisterDto;

public interface AuthService {
    AuthResponseDto register(UserRegisterDto userRegisterDto);
    AuthResponseDto login(UserLoginDto userLoginDto);

    String getCurrentUserEmail();
}