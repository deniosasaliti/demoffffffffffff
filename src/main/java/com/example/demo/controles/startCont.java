package com.example.demo.controles;

import com.example.demo.Entity.*;
import com.example.demo.repos.AuthorRepository;
import com.example.demo.repos.BookRepository;
import com.example.demo.repos.PostRepo;
import com.example.demo.repos.userRepos;
import com.example.demo.service.BookService;
import com.example.demo.service.MailService;
import com.example.demo.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;


@Controller
public class startCont {
    final
    UserService userService;
    final
    userRepos userRepos;
    final
    MailService mailService;
    final
    BookRepository bookRepository;
    final
    BookService bookService;

    final
    AuthorRepository authorRepository;

    final
    PostRepo postRepo;



    public startCont(UserService userService, userRepos userRepos, MailService mailService, BookRepository bookRepository, BookService bookService, AuthorRepository authorRepository, PostRepo postRepo) {
        this.userService = userService;

        this.userRepos = userRepos;

        this.mailService = mailService;

        this.bookRepository = bookRepository;
        this.bookService = bookService;

        this.authorRepository = authorRepository;
        this.postRepo = postRepo;
    }


    @GetMapping("/")

    public String index(Model model) {

        PageRequest pageRequest = PageRequest.of(0,5);
        List<Post> list = postRepo.
                findAll(pageRequest).getContent();
            model.addAttribute("list", list);

        return "index";
    }


    @GetMapping("/testPage")
    public String getTestPage(){
        return "testPage";
    }

    @GetMapping("/signup")

    public String signup(Model model) {

        model.addAttribute("user" ,new User());
        return "/signup";
    }

    @PostMapping("/validationForm")
    public String UserRegistration(@Valid User user,
                                   BindingResult result,
                                   Model model) throws Exception {


        if (!result.hasErrors()) {

            NotificationEmail notificationEmail = new
                    NotificationEmail(user.getName(),
                    user.getEmail(),
                    "http://myseria.net/");

            mailService.sendEmail(notificationEmail, model.asMap());
            model.addAttribute("name",user.getName());
            model.addAttribute("success",notificationEmail.getSuccessUrl());
            model.addAttribute("noError",result);
            userService.saveUser(user);

            return "/signup";
        }

        model.addAttribute("user", user);
        return "/signup";
    }
    @GetMapping("/hello")
    public String getHello(){
        return "hello";
    }

    @GetMapping("/login")
    public  String loginPage(@RequestParam (name = "error",required = false)
                             Boolean error,
                             Model model){
        if (Boolean.TRUE.equals(error)){
            model.addAttribute("error",true);
        }
        return "/login";
    }

    @GetMapping("/form")
    public String getForm(){
        return "/form";
    }






    @GetMapping("/textArea")
    public String getTestArea(){
        return "/parts/textArea";
    }







}

