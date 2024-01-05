package com.devtiro.dbprep.services;

import com.devtiro.dbprep.domain.Comment;

import java.util.Optional;

public interface CommentService {
    Optional<Comment> getComment(Long id);
}
