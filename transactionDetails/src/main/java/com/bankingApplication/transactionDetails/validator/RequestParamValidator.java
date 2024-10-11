package com.bankingApplication.transactionDetails.validator;

import java.math.BigDecimal;
import java.util.regex.Pattern;


public class RequestParamValidator {
    private static final String NAME_PATTERN = "^[a-zA-Z]++$";
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\\.+[a-zA-Z.]+$";
    private static final String NUMBER_PATTERN = "^\\d{10}$";
    private static final String ACCOUNT_NUM_PATTERN = "^[0-9]++$";
    private static final String AMOUNT_PATTERN = "^[0-9]+\\.[0-9]+$";


    public static boolean validateName(String value){

        Pattern pattern =  Pattern.compile(NAME_PATTERN);
        if(pattern.matcher(value).find()){
            return true;
        }
        return  false;
    }

    public static boolean validateEmail(String value){

        Pattern pattern =  Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(value).find();
    }

    public static boolean validateNumber(String value){

        Pattern pattern =  Pattern.compile(NUMBER_PATTERN);
        return pattern.matcher(value).find();
    }

    public static boolean validateAccountNumber(Long value){

        Pattern pattern =  Pattern.compile(ACCOUNT_NUM_PATTERN);
        return pattern.matcher(value.toString()).find();
    }

    public static boolean validateNumber(Long value){

        Pattern pattern =  Pattern.compile(NUMBER_PATTERN);
        return pattern.matcher(value.toString()).find();
    }

    public static boolean validateAmount(BigDecimal value){

        Pattern pattern =  Pattern.compile(AMOUNT_PATTERN);
        return pattern.matcher(value.toString()).find() && value.compareTo(BigDecimal.ZERO) > 0;
    }
}
