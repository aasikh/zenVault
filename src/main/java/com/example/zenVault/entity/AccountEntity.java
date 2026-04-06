package com.example.zenVault.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.groups.Default;

import java.time.LocalDateTime;

@Entity
@Table(name="Accounts")
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String accountNumber;

    @Column(nullable = false)
    @Min(0)
    private double balance;

    //MAKE ACC TYPE

    private String accountType;

    @ManyToOne()
    @JoinColumn(name="user_id")
    private UserEntity userEntity;

    @Column
    private LocalDateTime createAt;

    @Column
    private LocalDateTime updateAt;

    //getter and setter


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String account_number) {
        this.accountNumber = account_number;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
