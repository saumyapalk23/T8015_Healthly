package com.nighthawk.spring_portfolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class login {

    @GetMapping("/login")
    public String getLogin() {

        return "login";
    }
}
