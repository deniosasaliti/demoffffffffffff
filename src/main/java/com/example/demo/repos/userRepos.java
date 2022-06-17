package com.example.demo.repos;

import com.example.demo.Entity.Serial;
import com.example.demo.Entity.User;
import jdk.internal.dynalink.linker.LinkerServices;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;


public interface userRepos extends JpaRepository<User,Long> {
    @Transactional
    Optional<User> findUsersByName(String username);

    User findUserByEmailAndName
            (String email,String userName);
    User findUserByEmailNotLikeAndNameNotLike(String email,String name);

    User findByName(String userName);

    User getById(long id);

    List<User> getBySerials(Serial serial);

    @Query(value = "select u from User u left join u.serials s where s.id =:id")
    List<User> sssss(long id);








}
