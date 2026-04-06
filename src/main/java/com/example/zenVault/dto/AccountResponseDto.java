package com.example.zenVault.dto;

import com.example.zenVault.entity.AccountEntity;

public class AccountResponseDto {
private Long id;
private String accountType;
private double balance;

//getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String account_type) {

        this.accountType = account_type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
