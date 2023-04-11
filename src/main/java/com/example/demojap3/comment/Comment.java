package com.example.demojap3.comment;

import com.example.demojap3.post.Post;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

@Entity
@Data
//@NamedEntityGraph(name = "Comment.post",
//    attributeNodes = @NamedAttributeNode("post")
//)
public class Comment {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long id;

    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    private int up;

    private int down;

    private boolean best;

}
