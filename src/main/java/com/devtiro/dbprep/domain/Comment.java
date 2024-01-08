package com.devtiro.dbprep.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = {"post", "commentedBy"})
@Table(name = "Comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createdOn;
    private String content;

//    @ManyToOne
//    @JoinColumn(name = "parent_comment_id")
    private String parentComment;

//    @ManyToOne
//    @JoinColumn(name = "post_id")
    private Long post;

//    @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL)
    private List<String> replies ;

 //   @ManyToOne
 //   @JoinColumn(name = "commented_by_username") //"commented_by_username" is the column name
    private String commentedBy;

    private int likes;
}
