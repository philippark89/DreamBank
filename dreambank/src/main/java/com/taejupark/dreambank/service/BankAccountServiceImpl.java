package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.BankAccount;
import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.repository.BankAccountRepository;
import com.taejupark.dreambank.service.exception.BankAccountNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.swing.text.html.parser.Entity;

@Service
public class BankAccountServiceImpl implements BankAccountService{
    private final BankAccountRepository repository;

    @Autowired
    public BankAccountServiceImpl(BankAccountRepository repository) {
        this.repository = repository;
    }


    @Override
    public void newBankAccount(BankAccount bankAccount) {
        repository.save(bankAccount);
    }

    @Override
    public void deleteBankAccount(long id) {
        repository.deleteById(id);
    }

    @Override
    public BankAccount getById(long id) {
        BankAccount bankAccount;

        try {
            bankAccount = repository.findById(id).get();
        } catch (EntityNotFoundException e) {
            throw new BankAccountNotFoundException();
        }

        return bankAccount;
    }
}
