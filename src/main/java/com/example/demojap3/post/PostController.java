package com.example.demojap3.post;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Long id){
        Optional<Post> byId = postRepository.findById(id);
        Post post =byId.get();
        return  post.getTitle();
    }


    @GetMapping("/posts/{id}")
    public String getAPost2(@PathVariable("id") Post post){
        return  post.getTitle();
    }

}
