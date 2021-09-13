package com.example.demo.Dto;

import com.example.demo.Entity.Categories;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import org.springframework.data.web.ProjectedPayload;


import javax.persistence.Transient;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
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
