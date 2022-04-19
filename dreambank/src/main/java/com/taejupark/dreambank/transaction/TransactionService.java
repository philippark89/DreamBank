package com.taejupark.dreambank.transaction;

import com.taejupark.dreambank.customer.Customer;

import java.util.List;

public interface TransactionService {
    List<Transaction> getAllTransactions();
    void saveTransaction(Transaction transaction);
    Transaction getTransactionById(long id);
    void deleteCustomerById(long id);
}
