package com.example.demojap3.post;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

     List<Post> findByTitleStartsWith(String title);

     @Query("SELECT p  FROM Post AS p WHERE p.title =:title")
     List<Post> findByTitle(@Param("title") String title, Sort sort);


     @Modifying(clearAutomatically = true)
     @Query("UPDATE Post p  Set p.title =:title WHERE p.id =:id")
     int updateTitle(@Param("title") String title, @Param("id") Long id);


}
