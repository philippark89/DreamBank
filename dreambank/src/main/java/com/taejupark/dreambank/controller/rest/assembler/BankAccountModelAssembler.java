package com.taejupark.dreambank.controller.rest.assembler;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.controller.rest.CustomerRESTController;
import com.taejupark.dreambank.controller.rest.BankAccountRESTController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class BankAccountModelAssembler implements RepresentationModelAssembler<BankAccount, EntityModel<BankAccount>> {
    @Override
    public EntityModel<BankAccount> toModel(BankAccount bankAccount) {
        EntityModel<BankAccount> bankAccountEntityModel = EntityModel.of(bankAccount, linkTo(methodOn(BankAccountRESTController.class).getBankAccountById(bankAccount.getId())).withSelfRel(), WebMvcLinkBuilder.linkTo(methodOn(CustomerRESTController.class).getCustomerById(bankAccount.getId())).withRel("customer"));

        return bankAccountEntityModel;
    }

    //, linkTo(methodOn(BankAccountRESTController.class).getTransactions(bankAccount.getId(), 0, 10)).withRel("transactions").expand()
}
