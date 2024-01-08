package com.devtiro.dbprep.controllers;

import com.devtiro.dbprep.domain.User;
import com.devtiro.dbprep.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/newUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping(path = "/users")
    public ResponseEntity<Page<User>> listUsers(final Pageable pageable) {
        return new ResponseEntity<Page<User>>(userService.getUsers(pageable), HttpStatus.OK);
    }

    @GetMapping(path = "/users/{username}")
    public ResponseEntity<User> listUsers(@PathVariable("username") final String username) {
        return userService.getUser(username)
                .map(user -> new ResponseEntity<>(user, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
