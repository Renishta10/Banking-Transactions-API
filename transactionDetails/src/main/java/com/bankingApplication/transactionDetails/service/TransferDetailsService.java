package com.bankingApplication.transactionDetails.service;

import com.bankingApplication.transactionDetails.exception.BusinessValidateException;
import com.bankingApplication.transactionDetails.exception.InvalidRequestException;
import com.bankingApplication.transactionDetails.model.TransferDetails;
import com.bankingApplication.transactionDetails.model.UserAccount;
import com.bankingApplication.transactionDetails.repository.TransferDetailsRepository;
import com.bankingApplication.transactionDetails.repository.UserAccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.bankingApplication.transactionDetails.validator.RequestParamValidator.validateAmount;
import static com.bankingApplication.transactionDetails.validator.RequestParamValidator.validateNumber;

@Service
public class TransferDetailsService {

    private final TransferDetailsRepository transferDetailsRepository;
    private UserAccountRepository userAccountRepository;

    public TransferDetailsService(TransferDetailsRepository transferDetailsRepository, UserAccountRepository userAccountRepository) {
        this.transferDetailsRepository = transferDetailsRepository;
        this.userAccountRepository = userAccountRepository;
    }



    public String transferFunds(TransferDetails transferDetails)
            throws InvalidRequestException,BusinessValidateException {

        if (!validateAmount(transferDetails.getAmount())){
            throw new InvalidRequestException("Invalid Amount");
        } else if (!validateNumber(transferDetails.getSourceAccount())) {
            throw new InvalidRequestException("Invalid Source Account Number");
        }else if (!validateNumber(transferDetails.getDestinationAccount())) {
            throw new InvalidRequestException("Invalid Destination Account Number");
        }

       UserAccount sourceUserAccount = userAccountRepository.getUserAccount(transferDetails.getSourceAccount());

       if(sourceUserAccount == null){
           throw new BusinessValidateException("Source UserAccount not found");
       }
       if(transferDetails.getAmount().compareTo(sourceUserAccount.getInitialBalance()) > 0){
           throw  new BusinessValidateException("Insufficient Amount");
       }

        UserAccount destinationUserAccount = userAccountRepository.getUserAccount(transferDetails.getDestinationAccount());

        if(destinationUserAccount == null){
            throw new BusinessValidateException("Destination Account User not found");
        }

        sourceUserAccount.setInitialBalance(sourceUserAccount.getInitialBalance().subtract(transferDetails.getAmount()));
        userAccountRepository.createUserAccount(sourceUserAccount);

        destinationUserAccount.setInitialBalance(destinationUserAccount.getInitialBalance().add(transferDetails.getAmount()));
        userAccountRepository.createUserAccount(destinationUserAccount);

       transferDetailsRepository.createTransaction(transferDetails);


       return "Funds transferred successfully";
    }

    public List<TransferDetails> getTransactionDetails(Long accountNumber){
       return transferDetailsRepository.getTransactionDetails(accountNumber);
    }
}



