package com.example.demo.Dto.Post;

import com.example.demo.Entity.User;

import java.time.Instant;
import java.util.function.Consumer;

public class PostDto {
    String category;
    Long userId;
    String description;
    String userName;
    String createdDate;
    String image;
    String postName;
    Long postId;
    boolean filter;


    public PostDto() {
    }

    public PostDto(String category,Long userId, String description, String userName, String createdDate, String image, String postName, Long postId,boolean filter) {
        this.category = category;
        this.userId = userId;
        this.description = description;
        this.userName = userName;
        this.createdDate = createdDate;
        this.image = image;
        this.postName = postName;
        this.postId = postId;
        this.filter = filter;

    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean isFilter() {
        return filter;
    }

    public void setFilter(boolean filter) {
        this.filter = filter;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }


}
