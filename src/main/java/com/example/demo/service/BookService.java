package com.example.demo.service;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import com.example.demo.repos.AuthorRepository;
import com.example.demo.repos.BookRepository;
import org.hibernate.Hibernate;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookService {

    final AuthorRepository authorRepository;

    final BookRepository bookRepository;

    public BookService(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void showAuthors(List<Book> books){


        for (Book b :
                books) {

            System.out.println(b.getAuthors());

        }

    }

    public List<Book> lazyLoad(){
        return bookRepository.lazyLoad();
    }

    public Book getOneBookById (Long id){
        return bookRepository.findById(id).get();
    }


}
