package com.example.demojap3.post;

import org.assertj.core.api.Assertions;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
@Rollback(value = false)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void crud(){
        Post post =new Post();
        post.setTitle("jpa");
        postRepository.save(post);

       // List<Post> all=postRepository.findAll();
       // Assertions.assertThat(all.size()).isEqualTo(1);
    }


}