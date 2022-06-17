package com.example.demo.repos;

import com.example.demo.Dto.Post.PostDetail;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.Tag;
import com.example.demo.Entity.enums.Categories;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class PostRepoTest {
    @Autowired
    PostRepo postRepo;

    @Autowired
    TagRepositpry tagRepositpry;

    @Test
    void updateCounterUp() {
    }

    @Test
    void updateCounterDown() {
    }

    @Test
    void findAllByPostFetchJoinUser() {
    }

    @Test
    void findByCategories() {
    }

    @Test
    void countByCategories() {
    }

    @Test
    void findAllPostsByCategoryAndCommentsCount() {
    }

    @Test
    @Transactional
    void testFindAllPostsByCategoryAndCommentsCount() {
        Pageable  pageable = PageRequest.of(0,3);
        List<PostDetail> content = postRepo.findAllPostsByCategoryAndCommentsCount(pageable).getContent();
//
//        Assertions.assertEquals(3,content.size());
//        Assertions.assertNotNull(content.get(0).getUser().getRole());
//        System.out.println(content.get(0).getUser().getRole().getPermissions());
        System.out.println(content);

    }


    @Test
    void savePostTags() {

        Post post = new Post();
        Tag tag = new Tag();
        post.getTags().add(tag);
        post.setCategories(Categories.EVIL);

        postRepo.save(post);

    }


    @Test
    void savePostCommends() {
        Post post = new Post();
        Comment comment = new Comment();
        comment.setPost(post);
        post.getComments().add(comment);
        postRepo.save(post);
    }


//    @Test
//    void newTest(){
//        Post allPost = postRepo.getAllPost(4);
//        System.out.println(allPost.getComments());
//
//    }


}