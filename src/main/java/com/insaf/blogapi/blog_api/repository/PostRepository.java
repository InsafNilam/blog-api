package com.insaf.blogapi.blog_api.repository;

import com.insaf.blogapi.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {}