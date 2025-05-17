package com.example.Datilera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Datilera.dto.user.UserLoginDto;
import com.example.Datilera.dto.user.UserRegisterDto;
import com.example.Datilera.service.auth.AuthService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody @Valid UserRegisterDto userRegisterDto) {
        return ResponseEntity.ok(authService.register(userRegisterDto));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody @Valid UserLoginDto userLoginDto) {
        return ResponseEntity.ok(authService.login(userLoginDto));
    }
}