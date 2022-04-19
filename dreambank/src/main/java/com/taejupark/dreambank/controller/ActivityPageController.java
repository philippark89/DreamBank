package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerService;
import com.taejupark.dreambank.transaction.Transaction;
import com.taejupark.dreambank.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller
public class ActivityPageController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/user/activities")
    public String activities(Principal principal, Model model) {
        String email = principal.getName();
        Customer customer = customerService.getCustomerByEmail(email);
        List<Transaction> transactions = customer.getBankAccount().getTransaction();

        model.addAttribute("transactions", transactions);

//        System.out.println(transactions);
//        System.out.println();
//        System.out.println(transactionService.getAllTransactions());

        return "/user/activities";
    }
}
