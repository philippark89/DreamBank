package com.taejupark.dreambank.repository;

import com.taejupark.dreambank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
