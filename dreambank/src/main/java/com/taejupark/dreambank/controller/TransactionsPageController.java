package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.bankAccount.BankAccountService;
import com.taejupark.dreambank.transaction.Transaction;
import com.taejupark.dreambank.transaction.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TransactionsPageController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/admin/transactions")
    public String transactions(Model model) {
        List<Transaction> transactionList = transactionService.getAllTransactions();

        model.addAttribute("transactionList", transactionList);

        return "/admin/transactions";
    }
}
