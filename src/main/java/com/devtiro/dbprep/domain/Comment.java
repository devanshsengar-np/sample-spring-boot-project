package com.devtiro.dbprep.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = {"post", "commentedBy", "parentComment", "replies"})
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdOn;
    private String content;

    @ManyToOne
    @JoinColumn(name = "parent_comment_id")
    @JsonBackReference(value = "comment-comment")
    private Comment parentComment;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonBackReference(value = "post-comment")
    private Post post;

    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "comment-comment")
    private List<Comment> replies ;

    @ManyToOne
    @JoinColumn(name = "commented_by_username") //"commented_by_username" is the column name
    @JsonIgnore
    private User commentedBy;

    private int likes;

    @PrePersist
    public void prePersist() {
        // Set the createdOn attribute to the current date and time before persisting
        this.createdOn = LocalDateTime.now();
    }

    public Comment(Long id) {
        this.id = id;
    }
}
