package com.example.demojap3.post;

import jakarta.persistence.EntityManager;
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
//@Rollback(value = false)
class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;


    @Autowired
    private EntityManager entityManager;

    @Test
    public void crud(){
        Post post =new Post();
        post.setTitle("jpa");
        postRepository.save(post);

        List<Post> all=postRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
    }


    @Test
    public void save(){
        Post post=new Post();
        post.setId(1l);
        post.setTitle("jpa");
        Post savedPost=postRepository.save(post); //persist

        Assertions.assertThat(entityManager.contains(post)).isFalse();
        Assertions.assertThat(entityManager.contains(savedPost)).isTrue();
        Assertions.assertThat(savedPost==post);


        Post postUpdate=new Post();
        postUpdate.setId(1l);
        postUpdate.setTitle("hibernate");
        Post updatePost= postRepository.save(postUpdate); //update

        Assertions.assertThat(entityManager.contains(updatePost)).isTrue();
        Assertions.assertThat(entityManager.contains(postUpdate)).isFalse();
        Assertions.assertThat(updatePost==postUpdate);


        List<Post> all=postRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(1);
    }


}