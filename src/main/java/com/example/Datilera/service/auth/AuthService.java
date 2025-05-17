package com.example.Datilera.service.auth;

import com.example.Datilera.dto.auth.AuthResponseDto;
import com.example.Datilera.dto.user.UserLoginDto;
import com.example.Datilera.dto.user.UserRegisterDto;

public interface AuthService {
    AuthResponseDto register(UserRegisterDto userRegisterDto);
    AuthResponseDto login(UserLoginDto userLoginDto);

    String getCurrentUserEmail();
}