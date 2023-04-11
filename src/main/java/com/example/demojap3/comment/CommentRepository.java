package com.example.demojap3.comment;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {

//    @EntityGraph(value = "Comment", type = EntityGraph.EntityGraphType.LOAD)
//    Optional<Comment> loadCommentById(Long id);

     List<CommentSummary2> findByPost_Id(Long id);

     /**
      * ==> 다음과 같이 제네릭으로 변경
      */
     <T>List<T> findByPost_Id(Long id, Class<T> type);

}
