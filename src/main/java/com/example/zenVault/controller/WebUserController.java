package com.example.zenVault.controller;

import ch.qos.logback.core.model.Model;
import com.example.zenVault.dto.LoginRequestDto;
import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class WebUserController {
    private final UserService userService;
    public WebUserController(UserService userService){
        this.userService = userService;
    }
@GetMapping("/home")
    public String homePage(){
    return "index";
  }
@GetMapping("/register")
public String register(){
        return "register";
}
  @PostMapping("/register")
    public String register(@ModelAttribute RegisterRequestDto requestDto, RedirectAttributes redirectAttributes){
       userService.register(requestDto);
       redirectAttributes.addFlashAttribute("success" , "Successfully Register");
       return "redirect:/home";
   }
   @GetMapping("/login")
   public String login(){
        return "login";
   }
   @PostMapping("/login")
    public String login(@ModelAttribute LoginRequestDto loginRequestDto, RedirectAttributes redirectAttributes){
        userService.login(loginRequestDto);
        redirectAttributes.addFlashAttribute("success", "You are login successfully");
        return "redirect:/home";
   }
}
