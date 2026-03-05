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

	boolean valid = jwtService.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzcyNzAyMzgzLCJleHAiOjE3NzI3MDU5ODN9.y9-dI9FFswOr1nhAdnRmjIDxBAqBEXxzzdTVcEtatps");
		System.out.println(valid);

	}

}
