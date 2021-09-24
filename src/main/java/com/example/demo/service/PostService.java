package com.example.demo.service;

import com.example.demo.dto.CommentDto;
import com.example.demo.Entity.Categories;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Post;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.repos.CommentsRepo;
import com.example.demo.repos.PostRepo;
import com.example.demo.repos.VoteRepo;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {

    final
    PostRepo postRepo;
    final
    VoteRepo voteRepo;
    final CommentsRepo commentsRepo;

    public PostService(PostRepo postRepo, VoteRepo voteRepo, CommentsRepo commentsRepo) {
        this.postRepo = postRepo;
        this.voteRepo = voteRepo;
        this.commentsRepo = commentsRepo;
    }

    @Transactional
    public void updateCounterUp(Long id){
        postRepo.updateCounterUp(id);
    }
    @Transactional
    public void updateCounterDown(Long id){
        postRepo.updateCounterDown(id);
    }

    public Post findByPostById(Long id){
        return postRepo.findById(id).orElseThrow(()-> new SpringRedditException("user by id not found"));
    }



    @Transactional
    public void  save(Post post){
        postRepo.save(post);
    }

    @Transactional
    public List<Post> findAllByCategory(Categories categories, PageRequest pageRequest){
     return   postRepo.findByCategories(categories,pageRequest).getContent();
    }

    @Transactional
    public void save(CommentDto dto){
        Post post = postRepo.findById(dto.getId()).orElseThrow(()->new SpringRedditException("post by id not found"));
        Comment comment = new Comment();
        comment.setText(dto.getText());
        post.addComment(comment);
        commentsRepo.save(comment);

    }

}
