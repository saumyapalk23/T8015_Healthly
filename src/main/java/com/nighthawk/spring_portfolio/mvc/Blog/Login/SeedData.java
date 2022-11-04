package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedData implements CommandLineRunner {

    @Autowired
    private PostService postService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Post> posts = postService.getAll();

        if (posts.size() == 0) {

            Authority user = new Authority();
            user.setName("ROLE_USER");
            authorityRepository.save(user);

            Authority admin = new Authority();
            admin.setName("ROLE_ADMIN");
            authorityRepository.save(admin);

            Account account1 = new Account();
            Account account2 = new Account();

            account1.setFirstName("Prisha");
            account1.setLastName("Boreddy");
            account1.setEmail("Prisha@gmail.com");
            account1.setPassword("password");
            Set<Authority> authorities1 = new HashSet<>();
            authorityRepository.findById("ROLE_USER").ifPresent(authorities1::add);
            account1.setAuthorities(authorities1);


            account2.setFirstName("Serafina");
            account2.setLastName("Wong");
            account2.setEmail("serafina@gmail.com");
            account2.setPassword("password");

            Set<Authority> authorities2 = new HashSet<>();
            authorityRepository.findById("ROLE_ADMIN").ifPresent(authorities2::add);
            authorityRepository.findById("ROLE_USER").ifPresent(authorities2::add);
            account2.setAuthorities(authorities2);

            accountService.save(account1);
            accountService.save(account2);

            Post post1 = new Post();
            post1.setTitle("How to deal with Stress more effectively ");
            post1.setBody("One of the ways that we can do to help deal with all we have going on in life is time management. One of the tips we use is to plan out your week-- all homework, tests, and projects, and figure out how you plan to attack them and how long you want to spend on each. ");
            post1.setAccount(account1);

            Post post2 = new Post();
            post2.setTitle("Sleep!");
            post2.setBody("Sleep is a very important process that most teenagers don't have enough time to do. Sleeping makes sure that you will be able to have more clear thought, better memory, etc. So when trying to decide whether to stay up till four am studying for your math test or going to sleep, keep in mind that on little sleep-- studying is very unproductive.");
            post2.setAccount(account2);

            postService.save(post1);
            postService.save(post2);
        }
    }

}
