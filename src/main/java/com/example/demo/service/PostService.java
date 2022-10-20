package com.example.demo.service;

import com.example.demo.Dto.Comment.CommentDto;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.enums.Categories;
import org.springframework.data.domain.PageRequest;

import java.util.List;

public interface PostService {

    void updateCounterUp(Long id);

    void updateCounterDown(Long id);

    Post findByPostById(Long id);

    void  save(Post post);

    List<Post> findAllByCategory(Categories categories, PageRequest pageRequest);

    void save(CommentDto dto);
}
