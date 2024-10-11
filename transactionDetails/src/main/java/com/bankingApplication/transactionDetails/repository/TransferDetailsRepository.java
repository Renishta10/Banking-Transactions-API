package com.bankingApplication.transactionDetails.repository;

import com.bankingApplication.transactionDetails.model.TransferDetails;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TransferDetailsRepository {

    Set<TransferDetails> transferData = new HashSet<>();

    public void createTransaction (TransferDetails transferDetails){
        transferData.add(transferDetails);
        for (TransferDetails transferDetails1 : transferData){
            System.out.println("Transaction created for Key  = " + transferDetails1.getSourceAccount());
        }
    }

    public List<TransferDetails> getTransactionDetails(Long accountNumber){
        List<TransferDetails> transactionHistories = new ArrayList<>();
        System.out.println("Transfer data in get call" + transferData);

        for (TransferDetails transferDetails1 : transferData) {
            if (accountNumber.equals(transferDetails1.getSourceAccount())) {
                transactionHistories.add(transferDetails1);
                System.out.println(" Get key" + transferDetails1.getSourceAccount());
            }

        }
        return transactionHistories;
    }

}