package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.model.BankAccount;
import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.service.CustomerService;
import com.taejupark.dreambank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CustomerController {
    private CustomerService cs;
    private UserService userService;

    @Autowired
    public CustomerController(CustomerService cs, UserService userService) {
        this.cs = cs;
        this.userService = userService;
    }

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customerList", cs.getAllCustomer());
        return "customers";
    }

    // handling by create account
    @GetMapping("/newCustomer")
    public String newCustomerForm(Customer customer, Model model) {
        Customer newCustomer = new Customer();
        model.addAttribute("model", newCustomer);
        return "newCustomer";
    }

    @PostMapping("/newCustomer")
    public String newCustomer(@ModelAttribute("customer") @Valid Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newCustomer";
        }
        customer.setBankAccount(new BankAccount());
        cs.newCustomer(customer);

        return "redirect:/customers";
    }

    @GetMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id) {
//        cs.deleteCustomerById(id);


        return "redirect:/customers";
    }

    @GetMapping("/updateCustomer/{id}")
    public String updateCustomerForm(@PathVariable(value = "id") long id, Model model) {
        Customer customer = cs.getCustomerById(id);

        model.addAttribute("customer", customer);

        return "updateCustomer";
    }

}
