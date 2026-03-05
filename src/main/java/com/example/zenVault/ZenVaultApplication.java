package com.example.zenVault;

import com.example.zenVault.security.JwtService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZenVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenVaultApplication.class, args);

		JwtService jwtService = new JwtService();
		String token =  jwtService.generateToken(2L);
		System.out.println(token);
		
	}

}
