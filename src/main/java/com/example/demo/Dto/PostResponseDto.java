package com.example.demo.Dto;

public class PostResponseDto {
   private int voteCount;


    public PostResponseDto(int voteCount) {
        this.voteCount = voteCount;

    }

    public PostResponseDto() {
    }



    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }

    public int getVoteCount() {
        return voteCount;
    }




}
