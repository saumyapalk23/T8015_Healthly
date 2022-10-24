package com.nighthawk.spring_portfolio.mvc.Blog;

import javax.persistence.*;

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
}
