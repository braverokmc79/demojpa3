package com.example.demojap3.post;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class PostDto {
    private Long id;
    private String title;
    private String content;
    private Date created;
    @QueryProjection
    public PostDto(Long id, String title, String content, Date created) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.created = created;
    }

}
