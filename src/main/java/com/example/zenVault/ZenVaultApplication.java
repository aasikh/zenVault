package com.example.zenVault;

import com.example.zenVault.controller.UserController;
import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.security.JwtFilter;
import com.example.zenVault.security.JwtService;
import com.example.zenVault.service.UserService;
import io.jsonwebtoken.Claims;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ZenVaultApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZenVaultApplication.class, args);
//		JwtFilter jwtFilter = new JwtFilter();
//		JwtService jwtService = new JwtService();
//		String token =  jwtService.generateToken(2L);
//		System.out.println(token);
//
//	boolean valid = jwtService.validateToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzcyNzgwNzgyLCJleHAiOjE3NzI3ODQzODJ9.AxKbbjwVMUUd6J1bweNb14QCw5UUvzMq9x2BwFoineY");
//		System.out.println(valid);


		// print all claims
//
//	Long cl = jwtService.extractUserIDFromToken("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyIiwiaWF0IjoxNzcyNzgwOTQ3LCJleHAiOjE3NzI3ODQ1NDd9.2g1n2fwvRCqagZbUrUIYeqdr_k1iMoqE6yU5T76mtaI");
//		System.out.println(cl);


	}

}
