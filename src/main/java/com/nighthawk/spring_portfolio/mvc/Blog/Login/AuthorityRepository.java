package com.nighthawk.spring_portfolio.mvc.Blog.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    
}
