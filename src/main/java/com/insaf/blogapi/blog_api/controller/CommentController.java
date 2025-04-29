package com.insaf.blogapi.blog_api.controller;

import com.insaf.blogapi.blog_api.model.Comment;
import com.insaf.blogapi.blog_api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts/{postId}/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @GetMapping
    public List<Comment> getComments(@PathVariable Long postId) {
        return commentService.getCommentsByPostId(postId);
    }

    @PostMapping
    public Comment addComment(@AuthenticationPrincipal UserDetails userDetails,
                               @PathVariable Long postId,
                               @RequestBody Comment comment) {
        return commentService.addComment(userDetails.getUsername(), postId, comment);
    }

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}