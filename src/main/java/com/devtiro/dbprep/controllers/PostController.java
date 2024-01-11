package com.devtiro.dbprep.controllers;

import com.devtiro.dbprep.domain.Post;
import com.devtiro.dbprep.domain.User;
import com.devtiro.dbprep.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    private final PostService postService;

    public PostController(final PostService postService) {
        this.postService = postService;
    }


    @PostMapping(path = "/newPost")
    public ResponseEntity<Post> createUser(@RequestBody Post post) {
        Post savedPost = postService.savePost(post);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
    }

    @GetMapping(path = "/posts")
    public ResponseEntity<Page<Post>> listPosts(final Pageable pageable) {
        return new ResponseEntity<Page<Post>>(postService.getPosts(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/posts/{id}")
    public ResponseEntity<Post> listPosts(@PathVariable("id") final Long id) {
        return postService.getPost(id)
                .map(post -> new ResponseEntity<>(post, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
