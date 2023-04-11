package com.example.demojap3.post;

import com.example.demojap3.comment.Comment;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString(of={"title", "content"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
//@NamedQuery(name="Post.findByTitle", query="SELECT p  FROM Post AS p WHERE p.title =:title")
public class Post {
    @Id
    @GeneratedValue
    @Column(name = "post_id")
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Post(String content) {
        this.content = content;
    }

    @OneToMany(mappedBy = "post")
    public List<Comment> commentList=new ArrayList<>();

}
