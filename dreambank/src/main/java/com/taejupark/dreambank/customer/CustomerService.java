package com.taejupark.dreambank.customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers();
    void saveCustomer(Customer customer);
    Customer getCustomerById(long id);
    Customer getCustomerByEmail(String email);
    void deleteCustomerById(long id);
}
