package com.example.demo.Entity;

import com.example.demo.Entity.enums.Categories;
import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "post")
public class Post {


    public Post(Long postId,
                @NotBlank(message = "Post Name cannot be empty or Null") String postName,
                String url,
                String description,
                Integer voteCount,
                User user,
                Instant createdDate,
                String image) {

        this.image = image;
        this.id = postId;
        this.postName = postName;
        this.url = url;
        this.description = description;
        this.voteCount = voteCount;
        this.user = user;
        this.createdDate = createdDate;


    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String postName;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer voteCount = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Instant createdDate;
    private String image;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    @OneToMany(mappedBy ="post",orphanRemoval = true,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();



    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    Set<Tag> tags = new HashSet<>();




    public void addComment(Comment comment) {
      comments.add(comment);
      comment.setPost(this);
    }


    public void removeComment(Comment comment) {
        comments.remove(comment);
        comment.setPost(null);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Post post = (Post) o;
        return id != null && Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}