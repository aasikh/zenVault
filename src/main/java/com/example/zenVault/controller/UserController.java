package com.example.zenVault.controller;

import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.dto.RegisterResponseDto;
import com.example.zenVault.entity.UserEntity;
import com.example.zenVault.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class UserController {
private final UserService userService;
public UserController(UserService userService) {

    this.userService = userService;
}
    @PostMapping("/register")
    public String register(@RequestBody RegisterRequestDto request){
        System.out.println("Controller reached");
        return "WORKING";
    }
}
