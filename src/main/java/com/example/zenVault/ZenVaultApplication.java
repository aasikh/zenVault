package com.example.zenVault;

import com.example.zenVault.controller.UserController;
import com.example.zenVault.dto.RegisterRequestDto;
//import com.example.zenVault.security.JwtFilter;
//import com.example.zenVault.security.JwtService;
import com.example.zenVault.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class ZenVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenVaultApplication.class, args);

	}
}
