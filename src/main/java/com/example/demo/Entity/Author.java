package com.example.demo.Entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
public class Author {

    public Author(String authorName, Long id, List<Book> books) {
        this.authorName = authorName;
        this.id = id;
        this.books = books;
    }

    private String authorName;





    public Author() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany(mappedBy= "authors")
    List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getGroups() {
        return books;
    }

    public void setGroups(List<Book> books) {
        this.books = books;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;

    }


}
