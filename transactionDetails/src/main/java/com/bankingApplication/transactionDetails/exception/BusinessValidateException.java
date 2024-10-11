package com.bankingApplication.transactionDetails.exception;

public class BusinessValidateException extends RuntimeException{

    public BusinessValidateException(String message){
        super(message);
    }
}