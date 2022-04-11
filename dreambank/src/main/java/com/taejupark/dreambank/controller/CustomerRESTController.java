package com.taejupark.dreambank.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.service.CustomerService;
import com.taejupark.dreambank.service.assembler.CustomerModelAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
//        return customerService.getAllCustomer();
        List<EntityModel<Customer>> customers = customerService.getAllCustomer().stream().map(customerModelAssembler::toModel).collect(Collectors.toList());
        return CollectionModel.of(customers, linkTo(methodOn(CustomerRESTController.class)).withSelfRel().expand());
    }

    @GetMapping(version + "{id}")
    public EntityModel<Customer> getCustomerById(@PathVariable("id") long id) {
//        return customerService.getCustomerById(id);
        Customer customer = customerService.getCustomerById(id);
        return customerModelAssembler.toModel(customer);
    }

    @PostMapping(version)
    public void newCustomer(@RequestBody Customer newCustomer) {
        customerService.newCustomer(newCustomer);
    }
}
