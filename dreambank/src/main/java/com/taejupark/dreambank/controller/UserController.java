package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.model.BankAccount;
import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.model.Transaction;
import com.taejupark.dreambank.service.BankAccountService;
import com.taejupark.dreambank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Calendar;

@Controller
public class UserController {
    private final String user = "/user";

    @Autowired
    private CustomerService customerService;

    @Autowired
    private BankAccountService bankAccountService;

    @GetMapping(user + "/account") // -> Domain name
    public String account(Principal principal, Model model) {
        String email = principal.getName();
        Customer customer = customerService.getCustomerByEmail(email);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(customer.getCreatedDate());
        String date = String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" +
                        String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "-" +
                        String.valueOf(calendar.get(Calendar.YEAR));

        model.addAttribute("userFirstName", customer.getFirstName());
        model.addAttribute("userLastName", customer.getLastName());
        model.addAttribute("userEmail", customer.getEmail());
        model.addAttribute("userDate", date);

        return user + "/account"; // -> File Location
    }

    @GetMapping(user + "/balance")
    public String balance(Principal principal, Model model) {
        String email = principal.getName(); // -> current's email
        Customer customer = customerService.getCustomerByEmail(email);
        Transaction transaction = new Transaction();

        model.addAttribute("userBalance", customer.getBankAccount().getBalance());
        model.addAttribute("customerId", customer.getId());
        model.addAttribute("transaction", transaction);

        return user + "/balance";
    }

    @PostMapping(user + "/balance/{id}")
    public String updateBalance(@PathVariable long id, @ModelAttribute Transaction transaction) {
//        customerService.getCustomerById(id).getBankAccount().getTransactions().add(transaction);
        System.out.println(transaction);

        return "redirect:" + user + "/balance";
    }

    @GetMapping(user + "/activities")
    public String activities() {
        return user + "/activities";
    }
}
