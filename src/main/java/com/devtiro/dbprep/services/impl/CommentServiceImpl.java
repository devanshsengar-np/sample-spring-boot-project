package com.devtiro.dbprep.services.impl;

import com.devtiro.dbprep.domain.Book;
import com.devtiro.dbprep.domain.Comment;
import com.devtiro.dbprep.repositories.CommentRepository;
import com.devtiro.dbprep.services.CommentService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(final CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Optional<Comment> getComment(Long id) {
        return commentRepository.findById(id);
    }
}
