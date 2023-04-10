package com.example.demojap3.post;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostMyRepository postRepository;

    @GetMapping("/posts/{id}")
    public String getAPost(@PathVariable("id") Long id){
        Optional<Post> byId = postRepository.findById(id);
        Post post =byId.get();
        return  post.getTitle();
    }


//    @GetMapping("/posts/{id}")
//    public String getAPost2(@PathVariable("id") Post post){
//        return  post.getTitle();
//    }

    @GetMapping("/posts")
    public Page<Post> getPosts(Pageable pageable){
        return postRepository.findAll(pageable);
    }



    @GetMapping("/posts-ha")
    public PagedModel<EntityModel<Post>> getPosts(Pageable pageable, PagedResourcesAssembler<Post> assembler) {
        return assembler.toModel(postRepository.findAll(pageable));
    }




}
