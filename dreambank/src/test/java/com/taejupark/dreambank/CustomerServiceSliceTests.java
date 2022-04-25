package com.taejupark.dreambank;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerRepository;
import com.taejupark.dreambank.customer.CustomerServiceImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceSliceTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerService;

    @Before
    public void setup() {

    }

    @After
    public void cleanup() {
        // clean up the whole db
        customerRepository.deleteAll();
    }

    @Test
    public void customerServiceSaveCustomerShouldReturnCountOne() {
        customerService.saveCustomer(new Customer("test@bank.com", "dummy", "dummer", new BankAccount()));

        assertThat(customerRepository.count()).isEqualTo(1);
    }

    @Test
    public void customerServiceSaveAndDeleteCustomerShouldReturnCountZero() {
        Customer customer = new Customer("test@bank.com", "dummy", "dummer", new BankAccount());

        customerService.saveCustomer(customer);
        customerService.deleteCustomerById(customer.getId());

        assertThat(customerRepository.count()).isEqualTo(0);
    }

    @Test
    public void customerServiceSaveAndFindTheCustomerByIdShouldReturnObjectFromTheServiceById() {
        Customer expectedCustomer = new Customer("test@bank.com", "dummy", "dummer", new BankAccount());

        customerService.saveCustomer(expectedCustomer);

        Customer targetCustomer = customerService.getCustomerById(expectedCustomer.getId());
        System.out.println(expectedCustomer);
        System.out.println(targetCustomer);

        assertThat(expectedCustomer.getId()).isEqualTo(targetCustomer.getId());
    }
}
