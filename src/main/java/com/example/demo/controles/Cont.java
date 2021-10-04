package com.example.demo.controles;

import com.example.demo.Dto.CommentDto;
import com.example.demo.Dto.PostDto;
import com.example.demo.Dto.PostIdDto;
import com.example.demo.Dto.PostResponseDto;
import com.example.demo.Entity.*;
import com.example.demo.Entity.enums.Categories;
import com.example.demo.exceptions.NotAuthenticationException;
import com.example.demo.repos.CommentsRepo;
import com.example.demo.repos.PostRepo;
import com.example.demo.service.AwsBucketService;
import com.example.demo.service.PostService;
import com.example.demo.service.VoteService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

@RestController
public class Cont {


    @Value("${upload.path}")
    private String uploadPath;
    @Value("${app.awsServices.bucketName}")
    private String bucketName;

    final
    VoteService voteService;


    final
    PostService postService;

    final
    CommentsRepo commentsRepo;

    final
    PostRepo postRepo;

    final
    AwsBucketService awsBucketService;



    public Cont(VoteService voteService, PostService postService, CommentsRepo commentsRepo, PostRepo postRepo, AwsBucketService awsBucketService) {
        this.voteService = voteService;

        this.postService = postService;

        this.commentsRepo = commentsRepo;
        this.postRepo = postRepo;
        this.awsBucketService = awsBucketService;
    }







    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/postUp")
    public ResponseEntity<PostResponseDto> postUp  (@RequestBody() PostIdDto dto,
                                                    Authentication authentication){


        PostResponseDto response = new PostResponseDto();

        Post post;
        if (authentication!=null){
            post = voteService.voteUp(dto, authentication);
        }else
            throw  new NotAuthenticationException("u a not authenticated ");

        response.setVoteCount(post.getVoteCount());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,value = "/postDown")
    public ResponseEntity<PostResponseDto> postDown  (@RequestBody() PostIdDto dto,
                                                      Authentication authentication){
        Post post;
        if (authentication!=null){
            post = voteService.voteDown(dto, authentication);
        }else
            throw  new NotAuthenticationException("u a not authenticated ");

        PostResponseDto response = new PostResponseDto();
        response.setVoteCount(post.getVoteCount());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/addComment")
    public HttpStatus addCommend(@RequestBody() CommentDto commentDto,
                                     Authentication authentication){
        postService.save(commentDto);
        return  HttpStatus.OK;
    }



    @PostMapping("/addPost")
    public ResponseEntity<PostDto> addPost(@RequestParam("file") MultipartFile file,
                                           @RequestParam String description,
                                           @RequestParam String categories,
                                           Authentication authentication) throws IOException {
        String savedFileName = saveFile(file);

        DateTimeFormatter formatter =
                DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC));


        Post post = new Post();
        post.setCategories(Categories.valueOf(categories));
        post.setCreatedDate(Instant.now().truncatedTo(ChronoUnit.SECONDS));
        post.setDescription(description);
        post.setImage(savedFileName);
        post.setPostName(description);
        post.setUser((User) authentication.getPrincipal());
        postService.save(post);
      return   new ResponseEntity<>(new PostDto(post.getCategories().name(),post.getUser().getId(),post.getDescription(),
              post.getUser().getName(),
              post.getCreatedDate().toString(),
              post.getImage(),
              post.getPostName(),
              post.getPostId(),
              false),HttpStatus.OK);
    }

//    public  String saveFile(MultipartFile file) throws IOException {
//        if (!file.isEmpty()){
//            File uploadDir = new File(uploadPath);
//            if (!uploadDir.exists()){
//                uploadDir.mkdir();
//            }
//            String uuidFile = UUID.randomUUID().toString();
//            String resultFileName = uuidFile + "."
//                    + file.getOriginalFilename();
//            file.transferTo(new File(uploadPath+"/"
//                    + resultFileName));
//            return resultFileName;
//        }
//        return "";
//    }
    public  String saveFile(MultipartFile file) throws IOException {
        if (!file.isEmpty()){

            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "."
                    + file.getOriginalFilename();
          awsBucketService.upload(file,bucketName,resultFileName);
            return resultFileName;
        }
        return "";
    }

    }







