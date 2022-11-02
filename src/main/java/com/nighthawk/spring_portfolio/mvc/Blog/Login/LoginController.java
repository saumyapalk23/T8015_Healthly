package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class LoginController {
    
    @ResponseStatus(value=HttpStatus.OK)
    @GetMapping("/login")
    public String getLoginPage(){
        return"login";
    }
}
