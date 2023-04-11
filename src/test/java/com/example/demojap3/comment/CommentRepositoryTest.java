package com.example.demojap3.comment;

import com.example.demojap3.post.Post;
import com.example.demojap3.post.PostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;



@SpringBootTest
@Transactional
class CommentRepositoryTest {

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    PostRepository postRepository;

    @Test
    public void getCommentTest1(){
        savePost();
        Optional<Comment> byId = commentRepository.findById(1l);
        System.out.println("제목 = ? " +byId.get().getPost().getTitle());
    }

    private Comment savePost() {
        Post post = new Post();
        post.setTitle("jpa");
        Post savePost=postRepository.save(post);

        Comment comment=new Comment();
        comment.setComment("comment- hello ");
        comment.setPost(savePost);
        comment.setUp(10);
        comment.setDown(1);

        return commentRepository.save(comment);
    }


    @Test
    public void getCommentTest2(){
        savePost();
        commentRepository.findByPost_Id(1l).forEach(c->{
            System.out.println("====================================");
              System.out.println(c.getVotes());
            System.out.println("====================================");
        });
    }

    @Test
    public void getCommentOnelyTest(){
        savePost();
        commentRepository.findByPost_Id(1l, CommentOnly.class).forEach(c->{
            System.out.println("====================================");
            System.out.println(c.getComment());
            System.out.println("====================================");
        });
    }

}