package com.devtiro.dbprep.controllers;

import com.devtiro.dbprep.domain.User;
import com.devtiro.dbprep.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
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
