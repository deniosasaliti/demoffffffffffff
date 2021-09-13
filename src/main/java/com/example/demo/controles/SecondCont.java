package com.example.demo.controles;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.User;
import com.example.demo.Entity.Vote;
import com.example.demo.Entity.VoteType;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@Controller
public class SecondCont {

//    @Value("${upload.path}")
//    private String uploadPath;


final PostService postService;

    public SecondCont(PostService postService) {
        this.postService = postService;
    }









}


