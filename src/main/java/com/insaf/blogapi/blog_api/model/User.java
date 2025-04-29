package com.insaf.blogapi.blog_api.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id @GeneratedValue
    private Long id;

    private String username;
    private String email;
    private String password;
    private String role;
}