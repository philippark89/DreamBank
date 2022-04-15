package com.taejupark.dreambank.controller;

import com.taejupark.dreambank.model.Customer;
import com.taejupark.dreambank.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.Calendar;

@Controller
public class UserController {
    private final String user = "/user";

    @Autowired
    private CustomerService customerService;

    @GetMapping(user + "/account") // -> Domain name
    public String account(Principal principal, Model model) {
        String email = principal.getName();
        Customer customer = customerService.getCustomerByEmail(email);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(customer.getCreatedDate());
        String date = String.valueOf(calendar.get(Calendar.MONTH) + 1) + "-" +
                        String.valueOf(calendar.get(Calendar.DAY_OF_MONTH)) + "-" +
                        String.valueOf(calendar.get(Calendar.YEAR));

        model.addAttribute("userFirstName", customer.getFirstName());
        model.addAttribute("userLastName", customer.getLastName());
        model.addAttribute("userEmail", customer.getEmail());
        model.addAttribute("userDate", date);

        return user + "/account"; // -> File Location
    }

    @GetMapping(user + "/balance")
    public String balance() {
        return user + "/balance";
    }

    @GetMapping(user + "/activities")
    public String activities() {
        return user + "/activities";
    }
}
