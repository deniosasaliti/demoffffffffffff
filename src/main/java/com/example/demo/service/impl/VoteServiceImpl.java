package com.example.demo.service.impl;

import com.example.demo.Dto.Post.PostIdDto;
import com.example.demo.Entity.*;
import com.example.demo.Entity.enums.VoteType;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.repos.VoteRepo;
import com.example.demo.service.VoteService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class VoteServiceImpl  implements VoteService {

    final PostServiceImpl postService;
    final VoteRepo voteRepo;


    public VoteServiceImpl(PostServiceImpl postService, VoteRepo voteRepo) {
        this.postService = postService;
        this.voteRepo = voteRepo;


    }

    @Transactional
    public Post voteUp(PostIdDto dto, Authentication authentication) {

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
        post.setVoteCount(post.getVoteCount()+1);
        return post;

    }

    @Transactional
    public Post voteDown(PostIdDto dto, Authentication authentication) {

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
        post.setVoteCount(post.getVoteCount()-1);
        return post;

    }


}
