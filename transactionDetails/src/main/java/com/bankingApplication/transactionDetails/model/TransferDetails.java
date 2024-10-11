package com.bankingApplication.transactionDetails.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class TransferDetails {
    Long sourceAccount;
    Long destinationAccount;
    BigDecimal amount;
    Long id;
    LocalDate transferDate;

    public TransferDetails(Long sourceAccount, Long destinationAccount, BigDecimal amount, Long id, LocalDate transferDate) {
        this.sourceAccount = sourceAccount;
        this.destinationAccount = destinationAccount;
        this.amount = amount;
        this.id = id;
        this.transferDate = transferDate;
    }

    public Long getSourceAccount() {
        return sourceAccount;
    }

    public void setSourceAccount(Long sourceAccount) {
        this.sourceAccount = sourceAccount;
    }

    public Long getDestinationAccount() {
        return destinationAccount;
    }

    public void setDestinationAccount(Long destinationAccount) {
        this.destinationAccount = destinationAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(LocalDate transferDate) {
        this.transferDate = transferDate;
    }

    @Override
    public String toString() {
        return "TransferDetails{" +
                "sourceAccount=" + sourceAccount +
                ", destinationAccount=" + destinationAccount +
                ", amount=" + amount +
                ", id=" + id +
                ", transferDate=" + transferDate +
                '}';
    }
}
