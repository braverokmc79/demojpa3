package com.example.demojap3.comment;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 클래스방식 커스텀
 */
@Data
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentSummary2 {
    private  String comment;

    private int up;

    private int down;



    public String getVotes(){
        return getUp() + " : " +getDown();
    }

}
