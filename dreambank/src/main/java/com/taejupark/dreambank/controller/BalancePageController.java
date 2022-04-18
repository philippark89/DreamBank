package com.taejupark.dreambank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BalancePageController {

    @GetMapping("/user/balance")
    public String balance() {
        return "/user/balance";
    }
}
