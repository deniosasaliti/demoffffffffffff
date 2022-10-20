package com.example.demo.service;

import com.example.demo.Dto.Post.PostIdDto;
import com.example.demo.Entity.Post;
import org.springframework.security.core.Authentication;

public interface VoteService {

    Post voteUp(PostIdDto dto, Authentication authentication);

    Post voteDown(PostIdDto dto, Authentication authentication);
}
