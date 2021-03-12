package com.example.demo.Entity;

public class PostIdDto {
    public PostIdDto(String id) {
        this.id = id;
    }

    public PostIdDto() {
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
