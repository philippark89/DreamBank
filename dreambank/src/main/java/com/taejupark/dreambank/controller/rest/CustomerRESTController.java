package com.taejupark.dreambank.controller.rest;

import com.taejupark.dreambank.controller.rest.assembler.CustomerModelAssembler;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerRESTController {
    private final String version = "/api/v1/customers/";
    @Autowired
    private CustomerService customerService;
    @Autowired
    private CustomerModelAssembler customerModelAssembler;

    @GetMapping(version)
    public CollectionModel<EntityModel<Customer>> getAllCustomers() {
        List<EntityModel<Customer>> customers = customerService.getAllCustomers().stream().map(customerModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(customers, linkTo(methodOn(CustomerRESTController.class)).withSelfRel().expand());
    }

    @GetMapping(version + "{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable("id") long id) {
        Customer customer = customerService.getCustomerById(id);

        return customerModelAssembler.toModel(customer);
    }

//    @PostMapping(version)
//    public void newCustomer(@RequestBody Customer newCustomer) {
//        customerService.saveCustomer(newCustomer);
//    }
}
