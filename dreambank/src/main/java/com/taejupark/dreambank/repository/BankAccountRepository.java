package com.taejupark.dreambank.repository;

import com.taejupark.dreambank.model.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    Optional<BankAccount> findByCustomerId(long customerId);
}
