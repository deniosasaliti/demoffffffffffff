package com.example.demo.service;

import com.example.demo.Entity.Post;
import com.example.demo.repos.PostRepo;
import com.example.demo.repos.VoteRepo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    final
    PostRepo postRepo;
    final
    VoteRepo voteRepo;

    public PostService(PostRepo postRepo, VoteRepo voteRepo) {
        this.postRepo = postRepo;
        this.voteRepo = voteRepo;
    }

    @Transactional
    public void updateCounterUp(Long id){
        postRepo.updateCounterUp(id);
    }

    public Post getPost(Long id){
        return postRepo.findById(id).get();

    }

    @Transactional
    public void  save(Post post){
        postRepo.save(post);
    }
}
