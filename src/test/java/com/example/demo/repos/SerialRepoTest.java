package com.example.demo.repos;

import com.example.demo.Dto.*;
import com.example.demo.Entity.Actor;
import com.example.demo.Entity.Post;
import com.example.demo.Entity.Serial;
import com.example.demo.Entity.User;
import com.example.demo.service.SerialService;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.Tuple;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SerialRepoTest {

    @Autowired
    SerialService serialService;

    @Autowired
    SerialRepository serialRepository;

    @Autowired
    AudiRepository audiRepository;

    @Autowired
    PostRepo postRepository;


    @Autowired
    ActorRepository actorRepository;

    @Autowired
    userRepos userRepository;

    @Transactional
    @Test
    public void getSerialById(){

        SerialD2 serialByIdFetchAudios = serialService.getSerialByIdFetchAudios(1);
        Assertions.assertEquals(2,serialByIdFetchAudios.getAudioTracks().size());


    }


   @Test
    public void getListOfAudios(){

        Serial serial = new Serial();
        serial.setId(1L);
       List<AudioDto> rrr = audiRepository.findAllAudioBySerial(serial);
       Assertions.assertEquals(2,rrr.size());
   }

    @Test
    public void getAudiosLikeTuples(){


        List<Tuple> tupleAudios = audiRepository.getAdiosLikeTuples(1);

        System.out.println(tupleAudios.get(0));
        Assertions.assertEquals(2,tupleAudios.size());
    }


    @Test
    public void getSerialLikeMapper(){

        SerialD2 serial = serialService.getSerialByIdFetchAudios(1);

        System.out.println(serial.getId());
        System.out.println(serial.getOriginalName());
        System.out.println(serial.getAudioTracks());



    }
    @Transactional
    @Test
    public void getSerial(){

        Serial serial = serialRepository.findSerialById(1);
        Assertions.assertEquals(3,serial.getActors().size());


    }


    @Transactional
    @Test
    public void getPosts(){

        Post post = postRepository.getAllById(1);
        Assertions.assertEquals(2, post.getComments().size());


    }


    @Transactional
    @Test
    public void getSerials(){
        Actor actor = new Actor();
        actor.setId(1L);


        List<Serial> serials = serialRepository.findByActors(actor);


    }


    @Transactional
    @Test
    public void getSerialsFetchActorWithSerialName(){
        SerialD2 serialByIdFetchAudios = serialService.getSerialByIdFetchAudios(1);
        System.out.println(serialByIdFetchAudios.getActors().get(0).getSerial().get(0).getOriginalName());

    }



    @Transactional
    @Test
    public void getListOfSerialsByActor(){

        List<Actor> actorBySerial = actorRepository.getBySSS(1);

        Assertions.assertEquals(2,actorBySerial.size());
        Assertions.assertEquals(1,actorBySerial.get(0).getSerial().size());
        Assertions.assertEquals(1,actorBySerial.get(1).getSerial().size());
    }



    @Test
    public void qwe(){

        Actor actor = new Actor();
        actor.getSerial().add(new Serial());
        actorRepository.save(actor);

    }
    @Transactional
    @Test
    public void getSerialByActors(){
        userRepository.sssss(1);

    }

}
