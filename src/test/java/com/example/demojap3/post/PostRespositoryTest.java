package com.example.demojap3.post;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@SpringBootTest
@Transactional
@Rollback(value = false)
class PostRespositoryTest {


    @Autowired
    PostRespository postRespository;


    @Test
    public void crud(){

        Post post=new Post();
        post.setTitle("hello1");
        post.setContent("content1");
        post.setCreated(new Date());
        postRespository.save(post);

        Post post2=new Post();
        post2.setTitle("hello1");
        post2.setContent("content2");
        post2.setCreated(new Date());
        postRespository.save(post2);

        Post post3=new Post();
        post3.setTitle("hello3");
        post3.setContent("content3");
        post3.setCreated(new Date());
        postRespository.save(post3);

        PostSearchCondition condition =new PostSearchCondition();
        condition.setTitle("hello1");

        Page<PostDto> postList =postRespository.searchPostList(condition, PageRequest.of(0, 10));

        System.out.println("postList.getTotalElements() = " + postList.getTotalElements());
        postList.forEach(postDto -> System.out.println("postDto.toString() = " + postDto.toString()));

        Assertions.assertThat(postList.getNumberOfElements()).isEqualTo(2);
    }


}