package com.example.demo.Dto;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.User;
import com.example.demo.Entity.enums.Permissions;


import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Set;

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
