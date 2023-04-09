package com.example.demojap3.post;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRespository extends JpaRepository<Post, Long> , PostCustomRepository {
}
