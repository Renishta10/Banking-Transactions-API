package com.bankingApplication.transactionDetails.exception;

public class InvalidRequestException extends RuntimeException {

    public InvalidRequestException(String message){
        super(message);
    }

}