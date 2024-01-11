package com.devtiro.dbprep.services;

import com.devtiro.dbprep.domain.User;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService {
    Optional<User> getUser(String username);

    Page<User> getUsers(Pageable pageable);

    User saveUser(User user);
}
