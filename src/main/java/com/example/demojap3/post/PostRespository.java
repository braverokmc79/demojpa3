package com.example.demojap3.post;

import com.example.demojap3.MyRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends MyRepository<Post, Long>, PostCustomRepository {
}
