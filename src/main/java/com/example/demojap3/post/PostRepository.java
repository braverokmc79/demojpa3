package com.example.demojap3.post;

import com.example.demojap3.MyRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface PostRepository extends MyRepository<Post, Long>, PostCustomRepository{
}
