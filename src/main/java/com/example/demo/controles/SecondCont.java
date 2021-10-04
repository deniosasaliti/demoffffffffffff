package com.example.demo.controles;

import com.example.demo.service.PostService;
import org.springframework.stereotype.Controller;


@Controller
public class SecondCont {

//    @Value("${upload.path}")
//    private String uploadPath;


final PostService postService;

    public SecondCont(PostService postService) {
        this.postService = postService;
    }









}


