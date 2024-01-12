package com.devtiro.dbprep.services.impl;

import com.devtiro.dbprep.domain.User;
import com.devtiro.dbprep.repositories.UserRepository;
import com.devtiro.dbprep.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository){this.userRepository=userRepository;}
    @Override
    public Optional<User> getUser(Long username) {
        System.out.println("specific user query executed");
        return userRepository.findById(username);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        System.out.println("all users query executed");
        return userRepository.findAll(pageable);
    }

    @Override
    public User saveUser(User user) {
        System.out.println("new user query executed");
        userRepository.save(user);
        return user;
    }
}
