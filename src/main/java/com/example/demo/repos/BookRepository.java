package com.example.demo.repos;

import com.example.demo.Entity.Author;
import com.example.demo.Entity.Book;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.ManyToOne;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book,Long> {

    Optional<Book> findById(Long id);

//    @Query(value = "select  b from Book b left join fetch b.authors")
    List<Book> findAll();


    @Query(value = "select b from Book b left join fetch b.authors ")
    List<Book> lazyLoad();
    @Query(value = "select b from Book b left join fetch b.authors a where a = :author")
    Book findByAuthor(@Param(value = "author") Author author);



}
