package com.nighthawk.spring_portfolio.mvc.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
    @Autowired
    private PostService postService; 
    @Override
    public void run(String ... arg) throws Exception{
        List<Post> posts= postService.getAll();

        if(posts.size()==0){
            Post post1= new Post();
            post1.setTitle("Title of post 1");
            post1.setBody("This is the body of post1 ");
            postService.save(post1);
        }
    }
}
