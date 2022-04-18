package com.taejupark.dreambank.user;

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

    @GetMapping("/main") // -> actual domain name
    public String mainPage(Principal principal, Model model) {
        String url = "/user/postLogin";

        try {
            User user = userRepository.findByEmail(principal.getName());
            model.addAttribute("email", principal.getName());
            model.addAttribute("firstname", user.getFirstName());
        } catch (NullPointerException e) {
            url = "/admin/adminMain";
        }

        return url; // -> matching html file name
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/";
    }

}
