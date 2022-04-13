package com.taejupark.dreambank.service.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.taejupark.dreambank.controller.rest.BankAccountRESTController;
import com.taejupark.dreambank.controller.rest.CustomerRESTController;
import com.taejupark.dreambank.model.BankAccount;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class BankAccountModelAssembler implements RepresentationModelAssembler<BankAccount, EntityModel<BankAccount>> {

    @Override
    public EntityModel<BankAccount> toModel(BankAccount bankAccount) {
        EntityModel<BankAccount> bankAccountEntityModel = EntityModel.of(bankAccount, linkTo(methodOn(BankAccountRESTController.class).getBankAccountById(bankAccount.getId())).withSelfRel(), linkTo(methodOn(CustomerRESTController.class).getCustomerById(bankAccount.getCustomer().getId())).withRel("customer"), linkTo(methodOn(BankAccountRESTController.class).getTransactions(bankAccount.getId(), 0, 10)).withRel("transactions").expand());

        return bankAccountEntityModel;
    }
}
