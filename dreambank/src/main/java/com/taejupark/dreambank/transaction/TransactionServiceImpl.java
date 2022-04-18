package com.taejupark.dreambank.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    @Override
    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public Transaction getTransactionById(long id) {
        Transaction transaction;
        try {
            transaction = transactionRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new TransactionNotFoundException();
        }

        return transaction;
    }

    @Override
    public void deleteCustomerById(long id) {
        transactionRepository.deleteById(id);
    }
}
