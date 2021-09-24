package com.example.demo.dto;

import com.example.demo.Entity.User;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public interface PostDetail {

        String getCategories();
         String getUrl();
         String getDescription();
         Integer getVoteCount();
         User getUser();
         Instant getCreatedDate();
         String getImage();
         String getPostName();
         Long getPostId();
         Long getCommentCount();
         DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime( FormatStyle.MEDIUM )
                 .withZone( ZoneId.systemDefault());

 default String  transferDateTimeToString(Instant instant){
         return formatter.format(instant);
        }



}