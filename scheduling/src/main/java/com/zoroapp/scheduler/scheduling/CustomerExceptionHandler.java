package com.zoroapp.scheduler.scheduling;


import com.zoroapp.scheduler.scheduling.exceptions.DuplicateJobException;
import com.zoroapp.scheduler.scheduling.models.ErrorResponse;
import jakarta.persistence.NoResultException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomerExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> duplicateExceptionHandler(DuplicateJobException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
//        logger.error(this.getClass().toString(), exception);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> noResultExceptionHandler(NoResultException exception) {
        ErrorResponse response = new ErrorResponse(HttpStatus.NOT_FOUND.value(), exception.getMessage(), System.currentTimeMillis());
//        logger.error(this.getClass().toString(), exception);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
