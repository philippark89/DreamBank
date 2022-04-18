package com.taejupark.dreambank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ActivityPageController {

    @GetMapping("/user/activities")
    public String activities() {
        return "/user/activities";
    }
}
