package com.example.demojap3.post;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Data
@ToString(of={"title", "content"})
@NoArgsConstructor(access = AccessLevel.PUBLIC)
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    public Post(String content) {
        this.content = content;
    }



}
