package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.Transaction;
import org.springframework.data.domain.Page;


public interface TransactionService {
    Page<Transaction> getTransactions(long bankAccountId, int offset, int limit);

}
