package com.taejupark.dreambank;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerRepository;

import com.taejupark.dreambank.transaction.Transaction;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositorySliceTests {

    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setup() {

    }

    @Test
    public void findCustomerByEmailShouldReturnNull() {
        Customer customer = customerRepository.findCustomerByEmail("emptyAccount@bank.com"); // null
        assertThat(customer).isEqualTo(null);
    }

    @Test
    public void findExistCustomerByEmail() {

    }
}
