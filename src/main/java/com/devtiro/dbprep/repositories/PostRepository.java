package com.devtiro.dbprep.repositories;

import com.devtiro.dbprep.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends CrudRepository<Post, Long>,PagingAndSortingRepository<Post,Long>{

}