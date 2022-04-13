package com.taejupark.dreambank.model;

import com.taejupark.dreambank.utils.TransactionType;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "bank_account_id", nullable = false)
    private BankAccount bankAccount;
    @NotNull
    private double amount;
    @NotNull
    private long timeStamp;
    @NotNull
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

    public Transaction() {
    }

    public long getTransaction_id() {
        return id;
    }

    public void setTransaction_id(long transaction_id) {
        this.id = transaction_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccounts(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long date) {
        this.timeStamp = date;
    }
}
