package com.example.datilera.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.datilera.dto.user.UserDto;
import com.example.datilera.mapper.user.UserMapper;
import com.example.datilera.service.user.UserService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private UserService userService;
    private UserMapper userMapper;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id_user) {
        UserDto userDto=userMapper.userToUserDto(userService.getUserById(id_user));
        return ResponseEntity.ok(userDto);
    }
}