package com.insaf.blogapi.blog_api.service;

import com.insaf.blogapi.blog_api.model.Comment;
import com.insaf.blogapi.blog_api.model.Post;
import com.insaf.blogapi.blog_api.model.User;
import com.insaf.blogapi.blog_api.repository.CommentRepository;
import com.insaf.blogapi.blog_api.repository.PostRepository;
import com.insaf.blogapi.blog_api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Comment> getCommentsByPostId(Long postId) {
        return commentRepository.findAll().stream()
                .filter(comment -> comment.getPost().getId().equals(postId)).toList();
    }

    public Comment addComment(String email, Long postId, Comment comment) {
        User user = userRepository.findByEmail(email).orElseThrow();
        Post post = postRepository.findById(postId).orElseThrow();
        comment.setAuthor(user);
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        return commentRepository.save(comment);
    }

    public void deleteComment(Long id) {
        commentRepository.deleteById(id);
    }
}