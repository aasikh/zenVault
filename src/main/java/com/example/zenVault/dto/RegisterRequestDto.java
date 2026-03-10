package com.example.zenVault.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterRequestDto {
    @NotBlank
    private String Name;
    @Email
    @NotBlank
    private String Email;
    @NotBlank
    @Size(min = 6)
    private String Password;
    public String getName() {
        return Name;
    }
    public void setEmail(String email) {
        Email = email;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPassword() {
        return Password;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public String getEmail() {
        return Email;
    }
}
