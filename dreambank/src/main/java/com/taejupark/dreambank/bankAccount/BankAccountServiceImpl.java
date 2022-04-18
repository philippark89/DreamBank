package com.taejupark.dreambank.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Primary
public class BankAccountServiceImpl implements BankAccountService{
    private BankAccountRepository bankAccountRepository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @Override
    public List<BankAccount> getAllBankAccounts() {
        return bankAccountRepository.findAll();
    }

    @Override
    public void saveBankAccount(BankAccount bankAccount) {
        bankAccountRepository.save(bankAccount);
    }

    @Override
    public BankAccount getBankAccountById(long id) {
        BankAccount bankAccount;
        try {
            bankAccount = bankAccountRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new BankAccountNotFoundException();
        }
        return bankAccount;
    }

    @Override
    public void deleteBankAccountById(long id) {
        bankAccountRepository.deleteById(id);
    }
}
