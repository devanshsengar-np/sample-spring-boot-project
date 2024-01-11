package com.devtiro.dbprep.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = {"comments", "likedByUsers", "postUser"})
@Table(name = "Posts")

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdOn;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "post-comment")
    private List<Comment> comments;

    @ManyToMany
    @JoinTable(
            name = "post_like",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likedByUsers ;

    private int likeCount;

    private String caption;

    private String image;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference(value = "user-post")
    private User postUser;

    @PrePersist
    public void prePersist() {
        // Set the createdOn attribute to the current date and time before persisting
        this.createdOn = LocalDateTime.now();
    }
    public Post(Long id) {
        this.id = id;
    }
}
