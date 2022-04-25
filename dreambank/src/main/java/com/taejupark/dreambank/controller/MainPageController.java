package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerNotFoundException;
import com.taejupark.dreambank.customer.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainPageController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CustomerService customerService;

    @GetMapping("/main") // -> actual domain name
    public String mainPage(Principal principal, Model model) {
        String url = "/user/postLogin";

        // check if user role is admin or not
        try {
            Customer customer = customerService.getCustomerByEmail(principal.getName());
            model.addAttribute("firstname", customer.getFirstName());
            logger.info("User " + customer.getEmail() + " has logged in.");
        } catch (CustomerNotFoundException e) {
            logger.info("Admin has logged in.");
            url = "/admin/adminMain";
        }

        return url; // -> matching html file name
    }
}
