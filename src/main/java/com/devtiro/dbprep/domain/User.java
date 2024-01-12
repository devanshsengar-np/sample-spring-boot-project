package com.devtiro.dbprep.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
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
@Table(name = "Users" )
@ToString(exclude = {"posts", "likedPosts"})

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long username;

    private String name;
    private String bio;

    @OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "user-post")
    private List<Post> posts ;

    @ManyToMany(mappedBy = "likedByUsers", fetch = FetchType.LAZY)
    private Set<Post> likedPosts ;

    private String profilePicture;


    private String mobNo;


    //constructor for deserialization
    public User(Long username) {
        this.username = username;
    }
}
