package com.example.demo.repos;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoteRepo extends JpaRepository<Vote,Long> {

//    Optional<Vote> findByPostAndUserOrderByVote_idDesc(Post post, User user);
    boolean existsByPostAndUser(Post post,User user);

}
