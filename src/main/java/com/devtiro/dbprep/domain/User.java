package com.devtiro.dbprep.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

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
@Table(name = "Users")
public class User {

    @Id
    private String username;
    private String name;
    private String bio;

//    @OneToMany(mappedBy = "postUser", cascade = CascadeType.ALL)
//    private List<Post> posts ;
//
//    @ManyToMany(mappedBy = "likedByUsers")
//    private Set<Post> likedPosts ;
    private List<Long> posts;

    private String profilePicture;


    private String mobNo;
}
