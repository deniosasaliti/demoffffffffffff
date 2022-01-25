package com.example.demo.Entity;

import com.example.demo.Entity.enums.Categories;
import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

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
        this.post_id = postId;
        this.post_name = postName;
        this.url = url;
        this.description = description;
        this.vote_count = voteCount;
        this.user = user;
        this.created_date = createdDate;


    }

    public Post() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    @NotBlank(message = "Post Name cannot be empty or Null")
    private String post_name;
    @Nullable
    private String url;
    @Nullable
    @Lob
    private String description;
    private Integer vote_count = 0;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    private Instant created_date;
    private String image;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    @OneToMany(mappedBy ="post",orphanRemoval = true,fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> comments;






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
        return post_id != null && Objects.equals(post_id, post.post_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}