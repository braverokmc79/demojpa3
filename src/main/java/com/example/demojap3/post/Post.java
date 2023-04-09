package com.example.demojap3.post;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import java.util.Date;

@Entity
@Data
@ToString(of={"title", "content"})
public class Post {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @Lob
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

}
