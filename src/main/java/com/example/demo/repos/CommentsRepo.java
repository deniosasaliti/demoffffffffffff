package com.example.demo.repos;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Post;
import org.hibernate.boot.model.source.spi.Sortable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentsRepo extends JpaRepository<Comment,Long> {

    @Query(value = "select c from Comment c where c.post.post_id = :id ")
    List<Comment> findCommentByPostId(@Param( "id") Long id );

//
//    @Query(value = "select count (c.post.postId)   from  Comment c where  c.post.postId in :value  group by  " +
//            " c.post.postId  order by c.post.postId asc  ")
//    Integer[] selectCountCommentsByPostId(@Param("value") List value);


}
