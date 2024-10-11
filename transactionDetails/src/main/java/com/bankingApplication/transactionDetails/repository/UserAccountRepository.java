package com.bankingApplication.transactionDetails.repository;

import com.bankingApplication.transactionDetails.model.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserAccountRepository {

    Map<Long,UserAccount> userAccountData = new HashMap<>();

    public UserAccount createUserAccount(UserAccount userAccount) {
        userAccountData.put(userAccount.getAccountNumber(), userAccount);
        for (Map.Entry<Long,UserAccount> entry : userAccountData.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
        return userAccount;//variable name
    }

    public UserAccount getUserAccount (Long accountNumber){
        for (Map.Entry<Long,UserAccount> entry : userAccountData.entrySet()) {
            System.out.println("User Account created for Key = " + entry.getKey() + ", Value = " + entry.getValue());

            if(accountNumber.equals(entry.getKey())){
                return entry.getValue();
            }
        }
        return null;//variable name
    }
}