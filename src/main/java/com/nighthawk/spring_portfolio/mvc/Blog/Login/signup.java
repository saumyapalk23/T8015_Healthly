package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class signup {

    @Autowired
    private AccountService accountService;
    // CONTROLLER handles GET request for /birds, maps it to birds() method
    @GetMapping("/signup")
    public String Signup(Model model) {
        // load HTML VIEW (birds.html)
        Account account= new Account();
        model.addAttribute("account", account);
        return "signup";
    }

    @PostMapping("/register")
    public String registerNewUser(@ModelAttribute Account account){
        accountService.save(account);
        return"redirect:/";
    }
}

