package com.example.zenVault.exception;

public class UserAlreadyExistsException extends RuntimeException {
public UserAlreadyExistsException(String message) {
    super(message);
}
}
