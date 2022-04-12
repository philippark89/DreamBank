package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.BankAccount;

public interface BankAccountService {
    void newBankAccount(BankAccount bankAccount);
    void deleteBankAccount(long id);
    BankAccount getById(long id);
}
