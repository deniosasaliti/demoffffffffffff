package com.example.demo.repos;

import com.example.demo.Dto.Post.PostDetail;
import com.example.demo.Entity.enums.Categories;
import com.example.demo.Entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepo extends JpaRepository<Post,Long> {
    @Modifying
    @Query("update Post p set p.voteCount = p.voteCount +1 where p.id = :id")
    public void updateCounterUp(@Param("id") Long id);


    @Modifying
    @Query("update Post p set p.voteCount = p.voteCount -1 where p.id = :id")
    public void updateCounterDown(@Param("id") Long id);



//    Page<Post> list = findAll(PageRequest pageRequest);
    @Query(value = "select p  from Post p left join fetch  p.user",
    countQuery = "select count(p) from Post p")
     Page<Post> findAllByPostFetchJoinUser(PageRequest pageRequest);

    Page<Post> findByCategories(Categories categories, Pageable pageable);


    double countByCategories(Categories categories);

//    @Query(value = "select p,( select count (c) from Comment c where p.postId = c.post.postId) from Post p")
//    List<PostDto> findAllPostsByCategoriesAndCommentsCount(@Param("categories") Categories categories,
//                                                           Pageable pageable);
    @Transactional
    @Query(value = "select p.categories as categories,p.url as url,p.description as description,p.voteCount as voteCount,p.user as user,p.createdDate as createdDate,p.image as image,p.postName as postName,p.id as postId,count (c) as commentCount" +
            "  from Post p   " +
            "   left  join  p.comments c where p.categories = :category group by p")
    Page<PostDetail> findAllPostsByCategoryAndCommentsCount(@Param("category") Categories category,
                                                                Pageable pageable);

    @Transactional
    @Query(value = "select p.categories as categories,p.url as url,p.description as description,p.voteCount as voteCount,p.user  as user ,p.createdDate as createdDate,p.image as image,p.postName as postName,p.id as postId,count (c) as commentCount" +
            " from Post p" +
            " left join  p.comments c  group by p")
    Page<PostDetail> findAllPostsByCategoryAndCommentsCount(Pageable pageable);
    
    @Query(value = "select p from Post p join fetch p.comments where p.id = :id")
    PostDetail getAllPost(long id);


    Post getAllById(long id);







}




