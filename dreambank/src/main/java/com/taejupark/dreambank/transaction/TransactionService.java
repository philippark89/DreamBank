package com.taejupark.dreambank.transaction;

import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransactionById(long id);
    void deleteCustomerById(long id);
//    Page<Transaction> findPaginated(Pageable pageable);
}
