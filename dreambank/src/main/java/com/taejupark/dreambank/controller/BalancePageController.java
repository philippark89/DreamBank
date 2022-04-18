package com.taejupark.dreambank.controller;

import com.fasterxml.jackson.databind.deser.std.StringArrayDeserializer;
import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerRepository;
import com.taejupark.dreambank.customer.CustomerService;
import com.taejupark.dreambank.transaction.Transaction;
import com.taejupark.dreambank.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class BalancePageController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/balance")
    public String balance(Principal principal, Model model) {
        String email = principal.getName(); // return -> email
        Customer customer = customerService.getCustomerByEmail(email);
        BankAccount bankAccount = customer.getBankAccount();

        double getBalance = customer.getBankAccount().getBalance();


        model.addAttribute("customerId", customer.getId());
        model.addAttribute("getBalance", getBalance);
        model.addAttribute("transaction", new Transaction());

        return "/user/balance";
    }

    @PostMapping("/user/balance/{id}")
    public String updateBalance(@PathVariable long id, @ModelAttribute Transaction transaction) {

        Customer customer = customerService.getCustomerById(id);
        customer.getBankAccount().getTransaction().add(transaction);
        transactionService.saveTransaction(transaction);
        customerService.saveCustomer(customer);

        System.out.println(customer);
        System.out.println(transaction);
        System.out.println(id);

        return "redirect:/user/balance";
    }
}
