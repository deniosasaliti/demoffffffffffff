package com.example.demo.repos;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface AuthorRepository  extends JpaRepository<Author,Long> {


    @Query(value = "select a from Author a where a.books = :books")
    Set<Author> findAll(@Param("books")List<Book> books);
}
