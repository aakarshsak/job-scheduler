package com.zoroapp.job_scheduler.user_security;

import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> usernameNotFoundHandler(UsernameNotFoundException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
//        logger.error(this.getClass().toString(), exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
//        logger.error(this.getClass().toString(), exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
