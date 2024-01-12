package com.devtiro.dbprep.repositories;

import com.devtiro.dbprep.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends CrudRepository<User, Long>,
        PagingAndSortingRepository<User,Long> {
    // Custom queries if needed
}
