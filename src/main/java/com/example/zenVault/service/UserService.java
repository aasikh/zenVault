package com.example.zenVault.service;

import com.example.zenVault.dto.LoginRequestDto;
import com.example.zenVault.dto.LoginResponseDto;
import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.dto.RegisterResponseDto;
import com.example.zenVault.entity.UserEntity;
import com.example.zenVault.exception.InvalidCredentialsException;
import com.example.zenVault.exception.UserAlreadyExistsException;
import com.example.zenVault.exception.UserNotFound;
import com.example.zenVault.repository.UserRepository;
import com.example.zenVault.security.JwtService;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
private final JwtService jwtService;
    public UserService(BCryptPasswordEncoder passwordEncoder,
                       UserRepository userRepository, JwtService jwtService) {

        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }
    public RegisterResponseDto register(RegisterRequestDto request){
        Optional<UserEntity> existingUser = userRepository.findByEmail(request.getEmail());
        if(existingUser.isPresent()){
            throw new UserAlreadyExistsException("Email already registered");
        }
    // make object for set data in db
      UserEntity userEntity = new UserEntity();
      userEntity.setName(request.getName());
      userEntity.setEmail(request.getEmail());
      userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
      userEntity.setRole("User");
      UserEntity dbSaved = userRepository.save(userEntity);


      RegisterResponseDto response = new RegisterResponseDto();
      response.setMessage("Successfully registered");
      response.setId(dbSaved.getId());
      return response;
    }

    public LoginResponseDto login(LoginRequestDto request){
         Optional<UserEntity> existUser = userRepository.findByEmail(request.getEmail());
          if(existUser.isEmpty()){
              throw new UserNotFound("User not found");
          }
        UserEntity userEntity = existUser.get();
          if(!passwordEncoder.matches(request.getPassword(), userEntity.getPassword())){
              throw new InvalidCredentialsException("Invalid password");
          }
          LoginResponseDto response = new LoginResponseDto();
          String token = jwtService.generateToken(userEntity.getId());
          response.setToken(token);
          response.setMessage("Successfully logged in");
          return response;
    }
}
