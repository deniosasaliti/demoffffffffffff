package com.example.demo.repos;

import com.example.demo.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepo extends JpaRepository<Post,Long> {
    @Modifying
    @Query("update Post p set p.voteCount = p.voteCount +1 where p.postId = :id")
    public void updateCounterUp(@Param("id") Long id);
}
