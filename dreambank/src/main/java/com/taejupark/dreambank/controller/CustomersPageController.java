package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerService;
import com.taejupark.dreambank.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CustomersPageController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private UserService userService;

    @GetMapping("/admin/customers")
    public String customers(Model model) {
        List<Customer> customerList = customerService.getAllCustomers();

        model.addAttribute("customerList", customerList);
        model.addAttribute("customer", new Customer());

        return "/admin/customers";
    }

    @PostMapping("/admin/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerService.saveCustomer(customer);

        return "redirect:/admin/customers";
    }

    @GetMapping("/admin/updateCustomer/{id}")
    public String updateCustomer(@PathVariable(value = "id") long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "/admin/adminUpdater";
    }

    @GetMapping("/admin/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable(value = "id") long id, @ModelAttribute Customer customer) {
        customerService.deleteCustomerById(id);


        return "redirect:/admin/customers";
    }
}
