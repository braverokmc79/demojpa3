package com.example.demojap3.post;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PostListener {

    @EventListener
    public void onApplicationEvent(PostPublishedEvent event) {
        System.out.println("======================");
        System.out.println("Post 이벤트 발행, Post Id = " + event.getPost().getId() + ", Content = '" + event.getPost().getContent() + "'");
        System.out.println("======================");
    }
}