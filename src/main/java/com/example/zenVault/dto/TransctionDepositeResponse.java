package com.example.zenVault.dto;

public class TransctionDepositeResponse {
    private String message;
    private double amount;
  private double balance;
    //getter and setter

    public String getMessage() {
        return message;
    }
    public void setMessage(String message){
        this.message= message;
    }

    public double getAmount() {

        return amount;
    }

    public void setAmount(double amount) {

        this.amount = amount;
    }

    public void setBalance(double balance) {

        this.balance = balance;
    }

    public double getBalance() {

        return balance;
    }
}
