package com.taejupark.dreambank.bankAccount;

import java.util.List;

public interface BankAccountService {
    List<BankAccount> getAllBankAccounts();
    void saveBankAccount(BankAccount bankAccount);
    BankAccount getBankAccountById(long id);
    void deleteBankAccountById(long id);
}
