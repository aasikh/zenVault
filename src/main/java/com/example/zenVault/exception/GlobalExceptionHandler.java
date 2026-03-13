package com.example.zenVault.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiErrorResponse> handleUserExists(UserAlreadyExistsException ex) {

        ApiErrorResponse error =
                new ApiErrorResponse(HttpStatus.CONFLICT.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ApiErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex) {

        ApiErrorResponse error =
                new ApiErrorResponse(HttpStatus.UNAUTHORIZED.value(), ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {

        String message = ex.getBindingResult()
                .getFieldError()
                .getDefaultMessage();

        ApiErrorResponse error =
                new ApiErrorResponse(400, message);

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ApiErrorResponse> handleUserNotFound(UserNotFound us){
         ApiErrorResponse error = new ApiErrorResponse(HttpStatus.NOT_FOUND.value(), us.getMessage());
         return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}