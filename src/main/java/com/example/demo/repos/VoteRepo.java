package com.example.demo.repos;

import com.example.demo.Entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepo extends JpaRepository<Vote,Long> {

}
