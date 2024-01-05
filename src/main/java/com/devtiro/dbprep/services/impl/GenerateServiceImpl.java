package com.devtiro.dbprep.services.impl;

import com.devtiro.dbprep.domain.Comment;
import com.devtiro.dbprep.domain.Post;
import com.devtiro.dbprep.domain.User;
import com.devtiro.dbprep.repositories.UserRepository;
import com.devtiro.dbprep.services.GenerateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;

@Service
public class GenerateServiceImpl implements GenerateService {

    private final UserRepository userRepository;


    public GenerateServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Transactional
    public void generate() {
        // Create User
        User user = User.builder()
                .username("user1")
                .name("Sample User")
                .bio("This is a sample user.")
                .profilePicture("profile.jpg")
                .mobNo("1234567890")
                .build();

        // Create Posts
        Post post1 = Post.builder()
                .createdOn(LocalDateTime.now())
                .caption("Post 1 Caption")
                .image("post1.jpg")
                .postUser(user)
                .build();

        Post post2 = Post.builder()
                .createdOn(LocalDateTime.now())
                .caption("Post 2 Caption")
                .image("post2.jpg")
                .postUser(user)
                .build();

        // Create Comments for Post 1
        Comment comment1Post1 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Comment 1 for Post 1")
                .commentedBy(user)
                .post(post1)
                .likes(0)
                .build();

        Comment comment2Post1 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Comment 2 for Post 1")
                .commentedBy(user)
                .post(post1)
                .likes(0)
                .build();

        // Create Replies for Comment 1 in Post 1
        Comment reply1Comment1Post1 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Reply 1 for Comment 1 in Post 1")
                .commentedBy(user)
                .parentComment(comment1Post1)
                .likes(0)
                .build();

        Comment reply2Comment1Post1 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Reply 2 for Comment 1 in Post 1")
                .commentedBy(user)
                .parentComment(comment1Post1)
                .likes(0)
                .build();

        // Create Comments for Post 2
        Comment comment1Post2 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Comment 1 for Post 2")
                .commentedBy(user)
                .post(post2)
                .likes(0)
                .build();

        Comment comment2Post2 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Comment 2 for Post 2")
                .commentedBy(user)
                .post(post2)
                .likes(0)
                .build();

        // Create Replies for Comment 1 in Post 2
        Comment reply1Comment1Post2 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Reply 1 for Comment 1 in Post 2")
                .commentedBy(user)
                .parentComment(comment1Post2)
                .likes(0)
                .build();

        Comment reply2Comment1Post2 = Comment.builder()
                .createdOn(LocalDateTime.now())
                .content("Reply 2 for Comment 1 in Post 2")
                .commentedBy(user)
                .parentComment(comment1Post2)
                .likes(0)
                .build();

        // Add Comments and Replies to Posts
        post1.setComments(Arrays.asList(comment1Post1, comment2Post1));
        post2.setComments(Arrays.asList(comment1Post2, comment2Post2));

        comment1Post1.setReplies(Arrays.asList(reply1Comment1Post1, reply2Comment1Post1));
        comment1Post2.setReplies(Arrays.asList(reply1Comment1Post2, reply2Comment1Post2));

        // Add Posts to User
        user.setPosts(Arrays.asList(post1, post2));

        // Add liked Posts to User
        user.setLikedPosts(new HashSet<>(Arrays.asList(post1, post2)));

        // Save User (Cascading will save Posts, Comments, and Replies)
        userRepository.save(user);
    }
}
