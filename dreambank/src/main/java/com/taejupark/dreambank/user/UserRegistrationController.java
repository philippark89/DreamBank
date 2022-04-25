package com.taejupark.dreambank.user;

import javax.validation.Valid;

import com.taejupark.dreambank.bankAccount.BankAccount;
import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerService;
import com.taejupark.dreambank.security.UserRegistrationDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Random;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result){
        User existing = userService.findByEmail(userDto.getEmail());
        if (existing != null){
            result.rejectValue("email", null, "There is already an account registered with that email");
        }

        if (result.hasErrors()){
            return "registration";
        }

        User user = userService.save(userDto);
        customerService.saveCustomer(createCustomerFromUserDTO(userDto, user.getId()));
        logger.info("Account [" + user.getEmail() + "] has been created!");
        return "redirect:/registration?success";
    }

    private Customer createCustomerFromUserDTO(UserRegistrationDto userDto, Long id) {
        // initialize the customer entity when user create the account
        Random random = new Random();
        Customer customer = new Customer();

        customer.setEmail(userDto.getEmail());
        customer.setFirstName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());
        customer.setBankAccount(new BankAccount());

        customer.getBankAccount().setBalance((double) Math.round((random.nextDouble() * 10000) * 100) / 100);

        customer.getBankAccount().setTransaction(new ArrayList<>());

        return customer;
    }
}

