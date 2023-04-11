package com.example.demojap3.comment;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentOnly {

    private String comment;

}
