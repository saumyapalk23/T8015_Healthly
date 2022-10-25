package com.nighthawk.spring_portfolio.mvc.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nighthawk.spring_portfolio.mvc.Blog.Login.Account;
import com.nighthawk.spring_portfolio.mvc.Blog.Login.AccountService;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService; 

    @Autowired
    private AccountService accountService;
    @Override
    public void run(String ... arg) throws Exception{
        List<Post> posts= postService.getAll();

        if(posts.size()==0){
            Account account1= new Account();
            account1.setFirstName("user");
            account1.setLastName("user");
            account1.setEmail("user@gmail.com");
            account1.setPassword("password");
            accountService.save(account1);

            Post post1= new Post();
            post1.setTitle("Title of post 1");
            post1.setBody("This is the body of post1 ");
            post1.setAccount(account1);
            postService.save(post1);
        }
    }
}
