package com.devtiro.dbprep.services.impl;

import com.devtiro.dbprep.domain.Post;
import com.devtiro.dbprep.repositories.PostRepository;
import com.devtiro.dbprep.services.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(final PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Page<Post> getPosts(Pageable pageable) {
        return postRepository.findAll(pageable);
    }


}
