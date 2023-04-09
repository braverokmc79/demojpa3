package com.example.demojap3.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PostCustomRepository {
    public Page<PostDto> searchPostList(PostSearchCondition condition, Pageable pageable) ;

    public List<Post> findMyPost();

    public void deletePost(Post entity);
}
