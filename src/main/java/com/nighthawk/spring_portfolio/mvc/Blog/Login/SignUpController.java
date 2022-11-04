package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/signup")
    public String getRegisterForm(Model model) {

        Account account = new Account();
        model.addAttribute("account", account);
        return "signup";
    }

    @PostMapping("/signup")
    public String registerNewUser(@ModelAttribute Account account) {
        accountService.save(account);
        return "redirect:/";
    }

}