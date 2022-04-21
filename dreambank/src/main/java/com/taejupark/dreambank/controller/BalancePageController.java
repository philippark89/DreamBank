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

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.Principal;
import java.text.NumberFormat;

@Controller
public class BalancePageController {
    private final String URL = "/user";
    @Autowired
    private CustomerService customerService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping(URL + "/balance") // /user/balance
    public String balance(Principal principal, Model model) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String email = principal.getName(); // return -> email
        Customer customer = customerService.getCustomerByEmail(email);
        BigDecimal balance = new BigDecimal(customer.getBankAccount().getBalance());
        balance = balance.setScale(2, RoundingMode.CEILING);
        String formatted = formatter.format(balance);

        model.addAttribute("customerId", customer.getId());
        model.addAttribute("getBalance", formatted);
        model.addAttribute("transaction", new Transaction());

        return "/user/balance";
    }

    @PostMapping("/user/balance/{id}")
    public String updateBalance(@PathVariable long id, @ModelAttribute Transaction transaction) {

        // fetch currently logged in customer and add transaction to list.
        Customer customer = customerService.getCustomerById(id);
        double currentBalance = customer.getBankAccount().getBalance();
        double transactionAmount = transaction.getAmount();

        if ((transaction.getTransactionType().equals("withdraw")) && currentBalance >= transactionAmount) {
            customer.getBankAccount().setBalance(currentBalance - transactionAmount);
            // save both transaction and customer objects (updated)
            customer.getBankAccount().getTransaction().add(transaction);
            transactionService.saveTransaction(transaction);
            customerService.saveCustomer(customer);
        } else if (transaction.getTransactionType().equals("deposit")) {
            customer.getBankAccount().setBalance(currentBalance + transactionAmount);
            customer.getBankAccount().getTransaction().add(transaction);
            transactionService.saveTransaction(transaction);
            customerService.saveCustomer(customer);
        } else {
            System.out.println("transaction failed");
        }

        // console
        System.out.println(transaction);

        return "redirect:/user/balance";
    }
}
