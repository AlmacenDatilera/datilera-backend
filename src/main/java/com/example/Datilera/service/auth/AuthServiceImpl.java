package com.example.datilera.service.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.datilera.domain.User;
import com.example.datilera.dto.auth.AuthResponseDto;
import com.example.datilera.dto.user.UserLoginDto;
import com.example.datilera.dto.user.UserRegisterDto;
import com.example.datilera.exceptions.EmailAlreadyExistsException;
import com.example.datilera.exceptions.InvalidCredentialsException;
import com.example.datilera.exceptions.ResourceNotFoundException;
import com.example.datilera.repository.UserRepository;
import com.example.datilera.service.jwt.JwtService;
import com.example.datilera.service.user.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {

    private UserRepository userRepository;
    private UserService userService;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto register(UserRegisterDto userRegisterDto) {
        if (userRepository.existsByEmail(userRegisterDto.email())) {
            throw new EmailAlreadyExistsException("Usuario con email " + userRegisterDto.email() + " ya existe.");
        }else{
            User user = userService.createUser(userRegisterDto);
            return AuthResponseDto.builder().token(jwtService.getToken(user)).build();
        }
    }
    
    @Override
    public AuthResponseDto login(UserLoginDto userLoginDto) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDto.email(), userLoginDto.password()));
        } catch (BadCredentialsException var4) {
            throw new InvalidCredentialsException("Email o contraseña inválidos.");
        }
        UserDetails user = userRepository.findByEmail(userLoginDto.email()).orElseThrow(() -> {
            return new ResourceNotFoundException("Usuario con email: " + userLoginDto.email() + " no encontrado.");
         });
        String token = jwtService.getToken(user);
        return AuthResponseDto.builder().token(token).build();
    }

    @Override
    public String getCurrentUserEmail() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

}