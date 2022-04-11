package com.taejupark.dreambank.repository;

import com.taejupark.dreambank.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {
    Page<Transaction> findByBankAccountId(long id, Pageable pageable);
}
