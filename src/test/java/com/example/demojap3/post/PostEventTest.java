package com.example.demojap3.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;

@SpringBootTest
class PostEventTest {

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Test
    void eventListener() {
        Post post = new Post("hello world");
        System.out.println("======================================");
        PostPublishedEvent event = new PostPublishedEvent(post);

        applicationEventPublisher.publishEvent(event);

        System.out.println("======================================");
    }


}

