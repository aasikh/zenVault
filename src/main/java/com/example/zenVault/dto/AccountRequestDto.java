package com.example.zenVault.dto;

import com.example.zenVault.entity.AccountEntity;
import com.example.zenVault.entity.UserEntity;

import java.time.LocalDateTime;

public class AccountRequestDto {
//    private Long id;
    private String accountType;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

