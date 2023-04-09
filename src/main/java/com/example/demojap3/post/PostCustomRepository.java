package com.example.demojap3.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCustomRepository {
    public Page<PostDto> searchPostList(PostSearchCondition condition, Pageable pageable) ;
}
