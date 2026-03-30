package com.example.zenVault.controller;

import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
    @Autowired
    public UserService userService;

    @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequestDto request){
      userService.register(request);
      return "redirect:/index.html";
    }
}
