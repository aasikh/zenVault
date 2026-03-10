package com.example.zenVault.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Users")
public class UserEntity {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long Id;

@Column(nullable = false, length = 50)
    private String Name;
@Column(nullable = false, unique = true)
    private String Email;
@Column(nullable = false)
    private String Password;

public enum Status {
    ACTIVE, INACTIVE;
}
   @Enumerated(EnumType.STRING)
    private Status role;

    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
