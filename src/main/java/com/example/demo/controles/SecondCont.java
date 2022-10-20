package com.example.demo.controles;

import com.example.demo.service.impl.PostServiceImpl;
import org.springframework.stereotype.Controller;


@Controller
public class SecondCont {

//    @Value("${upload.path}")
//    private String uploadPath;


final PostServiceImpl postService;

    public SecondCont(PostServiceImpl postService) {
        this.postService = postService;
    }









}


