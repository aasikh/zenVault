package com.example.zenVault.dto;
import jakarta.validation.constraints.*;

public class RegisterRequestDto {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50)
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank
    private String email;

    @Pattern(regexp = "^[0-9]{10}$", message = "Contact must be 10 digits")
    private String contactNumber;

    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    @NotBlank
    private String role;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContactNumber() {
        return contactNumber;
    }
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
