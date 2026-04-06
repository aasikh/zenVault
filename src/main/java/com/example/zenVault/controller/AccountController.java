package com.example.zenVault.controller;

import com.example.zenVault.dto.AccountRequestDto;
import com.example.zenVault.dto.AccountResponseDto;
import com.example.zenVault.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class AccountController {

    @Autowired
    public AccountService accountService;


    @PostMapping("/create")
    public AccountResponseDto create(@RequestBody AccountRequestDto requestDto){
       return accountService.create(requestDto);
    }
    // 
}
