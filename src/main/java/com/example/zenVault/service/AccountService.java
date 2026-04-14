package com.example.zenVault.service;

import com.example.zenVault.dto.AccountRequestDto;
import com.example.zenVault.dto.AccountResponseDto;
import com.example.zenVault.entity.AccountEntity;
import com.example.zenVault.entity.UserEntity;
import com.example.zenVault.repository.AccountRepository;
import com.example.zenVault.repository.UserRepository;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {
private final UserRepository userRepository;
private final AccountRepository accountRepository;
public AccountService(UserRepository userRepository, AccountRepository accountRepository){
    this.userRepository = userRepository;
    this.accountRepository = accountRepository;
  }
    public AccountResponseDto create(AccountRequestDto requestDto){

        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserEntity existsUser = userRepository.findById(userId)
                .orElseThrow(()-> new RuntimeException("User not found"));
          AccountEntity accountEntity = new AccountEntity();
          
          accountEntity.setUserEntity(existsUser);
          accountEntity.setAccountNumber(genrateAccountNumber());
          accountEntity.setAccountType(requestDto.getAccountType());
          accountEntity.setBalance(0.0);
          accountEntity.setCreateAt(LocalDateTime.now());
          accountEntity.setUpdateAt(LocalDateTime.now());
        AccountEntity saved =   accountRepository.save(accountEntity);

          AccountResponseDto responseDto = new AccountResponseDto();
          responseDto.setId(saved.getId());
          responseDto.setAccountType(saved.getAccountType());
          responseDto.setBalance(saved.getBalance());
          responseDto.setAccountNumber(saved.getAccountNumber());
          return responseDto;
    }
    private String genrateAccountNumber(){
        return "ZN" + System.currentTimeMillis();
    }

}


// 1 step is extract user_id from token
// and check this user exists in user table is not return and tells to request please register/login
// 2 if user found then take json from postman
// 3 step is take json and user_id and based on these info create Account for user