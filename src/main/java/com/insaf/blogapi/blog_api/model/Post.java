package com.insaf.blogapi.blog_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Post {
    @Id @GeneratedValue
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    private User author;

    private LocalDateTime createdAt;
}