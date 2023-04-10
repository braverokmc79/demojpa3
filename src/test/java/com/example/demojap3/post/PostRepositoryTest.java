package com.example.demojap3.post;

import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


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



    @Test
    public void findByTitleStartWidth(){
        savePost();

        List<Post> all =postRepository.findByTitleStartsWith("Spring");
        Assertions.assertThat(all.size()).isEqualTo(1);
        all.forEach(p-> System.out.println("p :getTitle : " +p.getTitle()));
    }



    @Test
    public void findByTitleTest(){
        savePost();
        List<Post> all =postRepository.findByTitle("Spring" , Sort.by("title"));

        System.out.println("all.size() = " + all.size());
        all.forEach(p-> System.out.println("findByTitleTest => : " +p.getTitle()));
    }


    /**
     * 함수를 이용한 길이 정렬
     */

    @Test
    public void findByTitleTest2(){
        savePost();
        List<Post> all =postRepository.findByTitle("Spring" , JpaSort.unsafe("LENGTH(title)"));
        System.out.println("2.all.size() = " + all.size());
        all.forEach(p-> System.out.println("2.findByTitleTest => : " +p.getTitle()));
    }


    private Post savePost() {
        Post post =new Post();
        post.setTitle("Spring Data Jpa");
        return postRepository.save(post);  //persist
    }

    @Test
    public void updateTitle(){
        Post spring  =savePost();

        String hibernate="hibernate";
        int update=postRepository.updateTitle("hibernate", spring.getId());
        Assertions.assertThat(update).isEqualTo(update);

        Optional<Post> byId = postRepository.findById(spring.getId());
        Assertions.assertThat(byId.get().getTitle()).isEqualTo(hibernate);
    }

    /**
     *
     * ==>
     * 업데이트 는 다음과 같이 더티 체킹
     */
    @Test
    public void updateTitle2(){
        Post spring  =savePost();
        spring.setTitle("hibernate");

        List<Post> all=postRepository.findAll();
        Assertions.assertThat(all.get(0).getTitle()).isEqualTo("hibernate");
    }






}