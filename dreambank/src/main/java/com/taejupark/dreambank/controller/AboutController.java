package com.taejupark.dreambank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
    @GetMapping("/about") // -> Domain name
    public String aboutPage() {
        return "/permitAll/about"; // -> File Location
    }
}
