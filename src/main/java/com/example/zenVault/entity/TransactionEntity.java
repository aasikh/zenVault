package com.example.zenVault.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transctionType;
    private double amount;
    private double balance;
    private String sendingAccountNumber;
    private String recieveAccountNumber;
    private String status;
    private LocalDateTime createAt;
    private String accountNumber;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTransctionType() {
        return transctionType;
    }
    public void setTransctionType(String transctionType){
        this.transctionType= transctionType;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public String getRecieveAccountNumber() {
        return recieveAccountNumber;
    }
    public void setRecieveAccountNumber(String recieveAccountNumber){
        this.recieveAccountNumber = recieveAccountNumber;
    }

    public String getSendingAccountNumber() {
        return sendingAccountNumber;
    }

    public void setSendingAccountNumber(String sendingAccountNumber) {
        this.sendingAccountNumber = sendingAccountNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {

        return status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
