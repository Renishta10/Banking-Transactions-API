package com.bankingApplication.transactionDetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {

    private ErrorException err;

    @ExceptionHandler(value ={InvalidRequestException.class})
    public ResponseEntity<Object> handleException(InvalidRequestException e) {
        return new ResponseEntity <>(new ErrorException(
                e.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.BAD_REQUEST);

    }
    @ExceptionHandler(value = {BusinessValidateException.class})
    public ResponseEntity<Object> exceptionHandler(BusinessValidateException e){
        return new ResponseEntity<>(new ErrorException(
                e.getMessage(),HttpStatus.BAD_REQUEST, LocalDateTime.now()),HttpStatus.BAD_REQUEST);
    }
}