package com.example.demo.repos;

import com.example.demo.Dto.PostDetail;
import com.example.demo.Entity.enums.Permissions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class PostRepoTest {
    @Autowired
    PostRepo postRepo;

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
    }
}