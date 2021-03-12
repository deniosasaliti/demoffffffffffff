package com.example.demo.controles;

import com.example.demo.Entity.Post;
import com.example.demo.Entity.PostIdDto;
import com.example.demo.Entity.User;
import com.example.demo.service.PostService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class Cont {


    @Value("${upload.path}")
    private String uploadPath;


    final
    PostService postService;

    public Cont(PostService postService) {
        this.postService = postService;
    }







    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/postUp")
    public ResponseEntity<HttpStatus> postUp  (@RequestBody() PostIdDto dto){



        postService.updateCounterUp(Long.parseLong(dto.getId()));

        return ResponseEntity.ok(HttpStatus.OK);


    }


    @PostMapping("/addPost")
    public ResponseEntity<HttpStatus> addPost(@RequestParam("file") MultipartFile file,
                          @RequestParam String description,
                          Authentication authentication) throws IOException {
        String savedFileName = saveFile(file);

        Post post = new Post();
        post.setDescription(description);
        post.setImage(savedFileName);
        post.setPostName(description);
        post.setUser((User) authentication.getPrincipal());

        postService.save(post);
      return   ResponseEntity.ok(HttpStatus.OK);
    }

    public  String saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()){
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "."
                    + file.getOriginalFilename();
            file.transferTo(new File(uploadPath+"/"
                    + resultFileName));
            return resultFileName;
        }
        return "";
    }






}
