package com.taejupark.dreambank.service;

import com.taejupark.dreambank.model.Customer;

import java.util.List;

public interface CustomerService {
        List<Customer> getAllCustomer();
        void newCustomer(Customer customer);
        void deleteCustomerById(long id);
        Customer getCustomerById(long id);
        Customer getCustomerByEmail(String email);
}
