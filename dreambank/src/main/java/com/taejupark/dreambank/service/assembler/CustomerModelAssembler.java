package com.taejupark.dreambank.service.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.taejupark.dreambank.controller.rest.BankAccountRESTController;
import com.taejupark.dreambank.controller.rest.CustomerRESTController;
import com.taejupark.dreambank.model.Customer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer customer) {
        return EntityModel.of(customer, linkTo(methodOn(CustomerRESTController.class).getCustomerById(customer.getId())).withSelfRel(), linkTo(methodOn(CustomerRESTController.class).getAllCustomers()).withRel("customers").expand(), linkTo(methodOn(BankAccountRESTController.class).getBankAccountById(customer.getBankAccount().getId())).withRel("bankAccount"));
    }
}
