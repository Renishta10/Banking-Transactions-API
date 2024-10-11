package com.bankingApplication.transactionDetails.controller;

import com.bankingApplication.transactionDetails.model.TransferDetails;
import com.bankingApplication.transactionDetails.service.TransferDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("bankingApp")
public class TransferDetailsController {

    private final TransferDetailsService transferDetailsService;

    public TransferDetailsController(TransferDetailsService transferDetailsService) {
        this.transferDetailsService = transferDetailsService;
    }

    @PostMapping("/amount-transfer")
    public String transferFunds(@RequestBody TransferDetails transferDetails) throws Exception{
        return transferDetailsService.transferFunds(transferDetails);
    }

    @GetMapping("/transaction/{accountNumber}")
    public List<TransferDetails> getTransactionDetails(@PathVariable Long accountNumber){
        return transferDetailsService.getTransactionDetails(accountNumber);
    }
}