package com.codingshuttle.youtube.hospitalManagement.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApiError> handleUsernameNotFoundException(UsernameNotFoundException e) {
        ApiError newApiError = new ApiError("Username not found: "+e.getMessage(), HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(newApiError, newApiError.getStatus());
    }
}
