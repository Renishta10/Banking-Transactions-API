package com.bankingApplication.transactionDetails.controller;

import com.bankingApplication.transactionDetails.model.UserAccount;
import com.bankingApplication.transactionDetails.service.UserAccountService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("bankingApp")
public class UserAccountController {

    private final UserAccountService userAccountService;//initializing the service class object

    public UserAccountController(UserAccountService userAccountService) {//alt+insert
        this.userAccountService = userAccountService;
    }

    @PostMapping("/user-account")
    public UserAccount createUserAccount(@RequestBody UserAccount userAccount) {
        return userAccountService.createUserAccount(userAccount);

    }

}
