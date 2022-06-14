package com.example.demo.Dto;

import com.example.demo.Entity.Comment;

import java.util.List;

public interface PostD2 {
    Long getId();
    String getName();
    List<Comment> getComments();

}
