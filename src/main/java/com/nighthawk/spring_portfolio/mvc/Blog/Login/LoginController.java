package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String getLoginPage(){
        return"login";
    }
}
