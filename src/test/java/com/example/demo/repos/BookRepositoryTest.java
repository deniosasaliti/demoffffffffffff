package com.example.demo.repos;

import com.example.demo.Entity.Book;
import com.example.demo.Entity.User;
import com.example.demo.service.BookService;
import javafx.scene.effect.SepiaTone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class BookRepositoryTest {

    @Autowired
    BookService bookService;
    @Autowired
    userRepos userRepos;

    @Test
    void findOne(){
        Book book = bookService.getOneBookById(1L);
        Assertions.assertNotNull(book);
    }



    @Test
    void findAll() {
        List<Book> books = bookService.getAllBooks();
        Assertions.assertNotNull(books);
    }

    @Test
    void findUser(){
        User user = userRepos.findUserByEmailAndName
                ("hohol386@ukr.net","Denis");
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        assertNotNull(user);
    }

    @Test
    void findUserNotLike(){
        User user = userRepos.findUserByEmailNotLikeAndNameNotLike
                ("hohol386@ukr.net","Denis");
        System.out.println(user.getName());
        System.out.println(user.getEmail());
        assertNotNull(user);
    }
    @Test
    void findAllEndSort(){

        PageRequest pageable = PageRequest.of(0,1);
        List<User> users = userRepos.findAll(pageable).getContent();
        System.out.println(users);
        System.out.println(users.size());

        assertNotNull(users);
    }


}