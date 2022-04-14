package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.repository.CustomerRepository;
import com.taejupark.dreambank.service.exception.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository repository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Customer> getAllCustomer() {
        return repository.findAll();
    }

    @Override
    public void newCustomer(Customer customer) {
        repository.save(customer);
    }

    @Override
    public void deleteCustomerById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer;

        try {
            customer = repository.findById(id).get();
        } catch (NoSuchElementException e) {
            throw new CustomerNotFoundException(id);
        }

        return customer;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        return repository.findByEmail(email).get();
    }
}
