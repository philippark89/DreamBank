package com.taejupark.dreambank.service.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.taejupark.dreambank.controller.BankAccountRESTController;
import com.taejupark.dreambank.controller.CustomerRESTController;
import com.taejupark.dreambank.model.Customer;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CustomerModelAssembler implements RepresentationModelAssembler<Customer, EntityModel<Customer>> {

    @Override
    public EntityModel<Customer> toModel(Customer customer) {
        EntityModel<Customer> customerEntityModel = EntityModel.of(customer, linkTo(methodOn(CustomerRESTController.class).getCustomerById(customer.getId())).withSelfRel(), linkTo(methodOn(CustomerRESTController.class).getAllCustomers()).withRel("customers").expand(), linkTo(methodOn(BankAccountRESTController.class).getBankAccountById(customer.getBankAccount().getId())).withRel("bankAccount"));
        return customerEntityModel;
    }
}
