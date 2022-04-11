package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.Transaction;
import com.taejupark.dreambank.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Page<Transaction> getTransactions(long bankAccountId, int offset, int limit) {
        Pageable page = PageRequest.of(offset, limit, Sort.by("timeStamp").descending());
        Page<Transaction> transactions = transactionRepository.findByBankAccountId(bankAccountId, page);
        return transactions;
    }
}
