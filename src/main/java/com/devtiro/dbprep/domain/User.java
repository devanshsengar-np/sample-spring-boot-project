package com.devtiro.dbprep.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Users")
@ToString(exclude = {"posts", "likedPosts"})

public class User {

    @Id
    private String username;
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
    public User(String username) {
        this.username = username;
    }
}
