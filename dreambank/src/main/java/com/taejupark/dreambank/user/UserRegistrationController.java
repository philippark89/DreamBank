package com.taejupark.dreambank.user;

import javax.validation.Valid;

import com.taejupark.dreambank.customer.Customer;
import com.taejupark.dreambank.customer.CustomerService;
import com.taejupark.dreambank.user.User;
import com.taejupark.dreambank.security.UserRegistrationDto;
//import com.taejupark.dreambank.service.CustomerService;
import com.taejupark.dreambank.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

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

//        customerService.newCustomer(createCustomerFromUserDTO(userDto, user.getId()));
        return "redirect:/registration?success";
    }

    private Customer createCustomerFromUserDTO(UserRegistrationDto userDto, Long id) {
        // initialize the customer entity when user create the account
        Customer customer = new Customer();

        customer.setEmail(userDto.getEmail());
        customer.setFirstName(userDto.getFirstName());
        customer.setLastName(userDto.getLastName());

//        Random random = new Random();
//        Customer customer = new Customer();
//        BankAccount bankAccount = new BankAccount();
//
//        bankAccount.setId(id);
//        bankAccount.setBalance((double) Math.round((random.nextDouble() * 10000) * 100) / 100);
//
//        customer.setFirstName(userDto.getFirstName());
//        customer.setLastName(userDto.getLastName());
//        customer.setEmail(userDto.getEmail());
//        customer.setCreatedDate(new Date());
//        customer.setId(id);
//        customer.setBankAccount(bankAccount);

        return customer;
    }
}

