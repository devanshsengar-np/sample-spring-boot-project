package com.devtiro.dbprep.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdOn;

//    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
//    private List<Comment> comments;
//
//    @ManyToMany
//    @JoinTable(
//            name = "post_like",
//            joinColumns = @JoinColumn(name = "post_id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id"))
//    private Set<User> likedByUsers ;
    private List<Long>  comments;

    private int likeCount;

    private String caption;

    private String image;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User postUser;
    private String postUser;
}
