package com.nighthawk.spring_portfolio.mvc.Blog;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.nighthawk.spring_portfolio.mvc.Blog.Login.Account;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String title;
    @Column(columnDefinition="TEXT")
    private String body;
    private LocalDateTime createdAt;

    @NotNull
    @ManyToOne
    @JoinColumn(name="account_id", referencedColumnName="id", nullable=false)
    private Account account;
}
