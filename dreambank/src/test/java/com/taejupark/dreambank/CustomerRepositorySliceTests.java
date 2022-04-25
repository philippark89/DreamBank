package com.taejupark.dreambank;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerRepositorySliceTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Before
    public void setup() {
        customerRepository.save(new Customer("dummy@bank.com", "taeju", "park", new BankAccount()));
        System.out.println("db saved");
    }

    @After
    public void cleanup() {
        customerRepository.deleteAll();
        System.out.println("db cleared");
    }

    @Test
    public void findCustomerByEmailNonExistCustomerShouldReturnNull() {
        Customer customer = customerRepository.findCustomerByEmail("emptyAccount@bank.com"); // null
        assertThat(customer).isNull();
    }

    @Test
    public void findCustomerByEmailExistCustomerShouldReturnEntity() {
        Customer customerTarget = customerRepository.findCustomerByEmail("dummy@bank.com");

        assertThat(customerTarget).isNotNull();
    }

    @Test
    public void findCustomerByFirstNameShouldReturnNotNull() {
       Customer customerTarget = customerRepository.findCustomerByFirstName("taeju");

       assertThat(customerTarget).isNotNull();
    }

    @Test
    public void findAllCustomersShouldReturnIsNull() {
        Customer customerTarget = customerRepository.findCustomerByFirstName("dummy");

        assertThat(customerTarget).isNull();
    }
}
