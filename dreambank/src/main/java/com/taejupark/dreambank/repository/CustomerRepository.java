package com.taejupark.dreambank.repository;

import com.taejupark.dreambank.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
