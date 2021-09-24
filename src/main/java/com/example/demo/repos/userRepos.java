package com.example.demo.repos;

import com.example.demo.Entity.User;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.awt.print.Pageable;
import java.util.List;



public interface userRepos extends JpaRepository<User,Long> {

    User findUsersByName(String username);

    User findUserByEmailAndName
            (String email,String userName);
    User findUserByEmailNotLikeAndNameNotLike(String email,String name);

    User findByName(String userName);

    User findUserByEmail(String email);






}
