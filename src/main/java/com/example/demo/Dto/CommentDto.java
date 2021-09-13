package com.example.demo.Dto;

public class CommentDto {
    Long id;
    String text;

    public CommentDto(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public CommentDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
