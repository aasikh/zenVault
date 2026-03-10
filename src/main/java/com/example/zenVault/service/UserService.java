package com.example.zenVault.service;

import com.example.zenVault.dto.RegisterRequestDto;
import com.example.zenVault.dto.RegisterResponseDto;
import com.example.zenVault.entity.UserEntity;
import com.example.zenVault.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public UserService(BCryptPasswordEncoder passwordEncoder,
                       UserRepository userRepository) {

        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }
    public RegisterResponseDto register(RegisterRequestDto request){
        Optional<UserEntity> existingUser = userRepository.findByEmail(request.getEmail());
        if(existingUser.isPresent()){
            throw new RuntimeException("Email already registered");
        }
    // make object for set data in db
      UserEntity userEntity = new UserEntity();
      userEntity.setName(request.getName());
      userEntity.setEmail(request.getEmail());
      userEntity.setPassword(passwordEncoder.encode(request.getPassword()));
        System.out.println("Registering user");
        System.out.println(request.getEmail());
      userRepository.save(userEntity);


      RegisterResponseDto response = new RegisterResponseDto();
      response.setMessage("Successfully registered");
      response.setId(response.getId());
      return response;
    }
}
