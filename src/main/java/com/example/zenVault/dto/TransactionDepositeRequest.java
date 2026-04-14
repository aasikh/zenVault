package com.example.zenVault.dto;

public class TransactionDepositeRequest {
    private String accountNumber;
    private double amount;

    // getter and setter

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
