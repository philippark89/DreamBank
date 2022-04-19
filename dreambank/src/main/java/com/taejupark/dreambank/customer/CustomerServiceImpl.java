package com.taejupark.dreambank.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@Primary
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer;
        try {
            customer = customerRepository.getById(id);
        } catch (EntityNotFoundException e) {
            throw new CustomerNotFoundException();
        }

        return customer;
    }

    @Override
    public Customer getCustomerByEmail(String email) {
        Customer customer = customerRepository.findCustomerByEmail(email);

        if (customer == null) {
            throw new CustomerNotFoundException();
        }

        return customer;
    }

    @Override
    public void deleteCustomerById(long id) {
        customerRepository.deleteById(id);
    }
}
