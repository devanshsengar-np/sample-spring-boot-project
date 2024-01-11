package com.devtiro.dbprep.services;

import com.devtiro.dbprep.domain.Post;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Page<Post> getPosts(Pageable pageable);

    Post savePost(Post post);

    Optional<Post> getPost(Long id);
}
