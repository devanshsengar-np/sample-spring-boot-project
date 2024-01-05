package com.devtiro.dbprep.controllers;

import com.devtiro.dbprep.domain.Post;
import com.devtiro.dbprep.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/posts")
    public ResponseEntity<Page<Post>> listPosts(final Pageable pageable) {
        return new ResponseEntity<Page<Post>>(postService.getPosts(pageable), HttpStatus.OK);
    }

}
