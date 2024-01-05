package com.devtiro.dbprep.repositories;


import com.devtiro.dbprep.domain.Comment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommentRepository extends CrudRepository<Comment, Long> , PagingAndSortingRepository<Comment,Long> {
    // Custom queries if needed
}