package com.devtiro.dbprep.controllers;

import com.devtiro.dbprep.domain.Comment;
import com.devtiro.dbprep.domain.Post;
import com.devtiro.dbprep.services.CommentService;
import com.devtiro.dbprep.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(final CommentService commentService) {
        this.commentService = commentService;
    }

//    @GetMapping(path = "/posts")
//    public ResponseEntity<Page<Post>> listPosts(final Pageable pageable) {
//        return new ResponseEntity<Page<Post>>(PostService.getPosts(pageable), HttpStatus.OK);
//    }

    @GetMapping(path = "/comments/{id}")
    public ResponseEntity<Comment> listComments(@PathVariable("id") final Long id) {
        return commentService.getComment(id)
                .map(comment-> new ResponseEntity<>(comment, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
