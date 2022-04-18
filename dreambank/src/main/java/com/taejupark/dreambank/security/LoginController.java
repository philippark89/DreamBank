package com.taejupark.dreambank.security;

import com.taejupark.dreambank.user.User;
import com.taejupark.dreambank.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class LoginController {
    private UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }



    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

}
