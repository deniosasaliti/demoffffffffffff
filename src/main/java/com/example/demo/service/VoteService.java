package com.example.demo.service;

import com.example.demo.Dto.PostIdDto;
import com.example.demo.Entity.*;
import com.example.demo.Entity.enums.VoteType;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.repos.VoteRepo;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class VoteService {

    final PostService postService;
    final VoteRepo voteRepo;


    public VoteService(PostService postService, VoteRepo voteRepo) {
        this.postService = postService;
        this.voteRepo = voteRepo;


    }

    @Transactional
    public Post voteUp(PostIdDto dto, Authentication authentication) throws SpringRedditException{

        Post post = postService.findByPostById(dto.getId());
        User user = (User) authentication.getPrincipal();



        boolean voted = voteRepo.existsByPostAndUser(post,user);
        if (voted)
            throw new SpringRedditException("u a ready voted");


        Vote vote = new Vote();
        vote.setVotetype(VoteType.UPVOTE);
        vote.setPost(post);
        vote.setUser(user);
        voteRepo.save(vote);
        post.setVote_count(post.getVote_count()+1);
        return post;

    }

    @Transactional
    public Post voteDown(PostIdDto dto, Authentication authentication) throws SpringRedditException{

        Post post = postService.findByPostById(dto.getId());
        User user = ((User) authentication.getPrincipal());
        boolean voted = voteRepo.existsByPostAndUser(post,user);

        if (voted){
            throw  new SpringRedditException("u a ready voted");
        }
        Vote vote = new Vote();
        vote.setVotetype(VoteType.UPVOTE);
        vote.setPost(post);
        vote.setUser(user);
        voteRepo.save(vote);
        post.setVote_count(post.getVote_count()-1);
        return post;

    }


}
