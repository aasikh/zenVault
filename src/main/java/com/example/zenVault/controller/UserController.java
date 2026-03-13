package com.example.zenVault.controller;

import com.example.zenVault.dto.LoginRequestDto;
import com.example.zenVault.dto.LoginResponseDto;
import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.dto.RegisterResponseDto;
import com.example.zenVault.entity.UserEntity;
import com.example.zenVault.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
private final UserService userService;
public UserController(UserService userService) {

    this.userService = userService;
}
    @PostMapping("/register")
    public RegisterResponseDto register(@Valid  @RequestBody RegisterRequestDto request){
    return   userService.register(request);
    }

    @PostMapping("/login")
    public LoginResponseDto login(@Valid @RequestBody LoginRequestDto request){
       return userService.login(request);
    }
}
