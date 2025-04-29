package com.insaf.blogapi.blog_api.repository;

import com.insaf.blogapi.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {}