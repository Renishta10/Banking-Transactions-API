package com.bankingApplication.transactionDetails.service;

import com.bankingApplication.transactionDetails.exception.InvalidRequestException;
import com.bankingApplication.transactionDetails.model.UserAccount;
import com.bankingApplication.transactionDetails.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import static com.bankingApplication.transactionDetails.validator.RequestParamValidator.*;


@Service
public class UserAccountService {



    private final UserAccountRepository userAccountRepository;

    public UserAccountService(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }

    public UserAccount createUserAccount(UserAccount userAccount) throws InvalidRequestException {

        if (!validateName(userAccount.getFirstName())){
            throw new InvalidRequestException("Invalid First Name");
        } else if (!validateName(userAccount.getLastName())){
            throw new InvalidRequestException("Invalid Last Name");
        } else if (!validateEmail(userAccount.getEmail())){
            throw new InvalidRequestException("Invalid Email");
        } else if (!validateNumber(userAccount.getPhoneNumber())){
            throw new InvalidRequestException("Invalid Phone Number");
        } else if (!validateAmount(userAccount.getInitialBalance())){
            throw new InvalidRequestException("Invalid Amount");
        } else if (!validateAccountNumber(userAccount.getAccountNumber())){
            throw new InvalidRequestException("Invalid Account Number");
        }

        return userAccountRepository.createUserAccount(userAccount);//passing data using variable name

    }



}