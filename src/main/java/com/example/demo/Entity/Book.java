package com.example.demo.Entity;



import javax.persistence.*;
import java.util.List;
import java.util.Set;
@Entity
public class Book {
    public Book(String name, Long id, Set<Author> authors) {
        this.name = name;
        this.id = id;
        this.authors = authors;
    }

    public Book() {
    }


    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(
            name = "book_authors",
            joinColumns = {
                    @JoinColumn(name = "book_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "author_id")})

    Set<Author> authors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
