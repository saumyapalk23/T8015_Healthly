package com.nighthawk.spring_portfolio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nighthawk.spring_portfolio.mvc.Blog.Post;
import com.nighthawk.spring_portfolio.mvc.Blog.PostService;

@Controller  // HTTP requests are handled as a controller, using the @Controller annotation
public class Blog {
    @Autowired
    private PostService postService;

    @GetMapping("/blog")
    public String blog(Model model) {
        List<Post> posts= postService.getAll();
        model.addAttribute("posts", posts);
        return "blog";

    }
}

