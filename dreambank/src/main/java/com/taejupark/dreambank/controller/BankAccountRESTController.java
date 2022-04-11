package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.model.BankAccount;
import com.taejupark.dreambank.model.Transaction;
import com.taejupark.dreambank.service.BankAccountService;
import com.taejupark.dreambank.service.TransactionService;
import com.taejupark.dreambank.service.assembler.BankAccountModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankAccountRESTController {
    private final String version = "/api/v1/bankaccounts/";
    @Autowired
    private BankAccountService bankAccountService;
    @Autowired
    private BankAccountModelAssembler bankAccountModelAssembler;
    @Autowired
    private TransactionService transactionService;

    @GetMapping(version + "{id}")
    public EntityModel<BankAccount> getBankAccountById(@PathVariable("id") long id) {
        BankAccount bankAccount = bankAccountService.getById(id);

        return bankAccountModelAssembler.toModel(bankAccount);
    }

    @GetMapping(version + "{id}" + "/transactions")
    public ResponseEntity<List<Transaction>> getTransactions(@PathVariable("id") long id, @RequestParam(value = "offset", required = false, defaultValue = "0") int offset, @RequestParam(value = "limit", required = false, defaultValue = "10") int limit) {
        Page<Transaction> transactions = transactionService.getTransactions(id, offset, limit);

        return ResponseEntity.ok().body(transactions.getContent());
    }

}
