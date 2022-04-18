package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerRepository;
import com.taejupark.dreambank.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Calendar;

@Controller
public class AccountPageController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/user/account") // -> Domain name
    public String account(Principal principal, Model model) {
        String email = principal.getName(); // -> email
        Customer customer = customerService.getCustomerByEmail(email);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(customer.getCreatedDate());
        String date = String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" +
                String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "-" +
                String.valueOf(calendar.get(Calendar.YEAR));

        model.addAttribute("userDate", date);
        model.addAttribute("customer", customer);

        return "/user/account"; // -> File Location
    }

    @PostMapping("/user/saveCustomer")
    public String saveCustomer(@ModelAttribute Customer customer) {
        customerRepository.save(customer);

        return "redirect:/user/account";
    }

    @GetMapping("/user/updateCustomer/{id}")
    public String updateCustomer(@PathVariable(value = "id") long id, Model model) {
        Customer customer = customerService.getCustomerById(id);
        model.addAttribute("customer", customer);

        return "/user/updateCustomer";
    }
}
