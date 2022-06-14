package com.example.demo.repos;

import com.example.demo.Dto.ActorD3;
import com.example.demo.Dto.ActorDto;
import com.example.demo.Dto.ActorDto2;
import com.example.demo.Dto.SerialD2;
import com.example.demo.Entity.Actor;
import com.example.demo.Entity.Serial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ActorRepository extends JpaRepository<Actor,Long> {


    @Query("select new com.example.demo.Dto.ActorDto2(a.id,a.name) from Actor a")
    List<ActorDto2> getActorBySerial(Serial serial);
    @Query("select  a from Actor a left  join  a.serial s where s.id =:id")
    List<Actor> getBySSS(long id);
    @Query("select  a from Actor a left join  a.serial s where s.id =:id")
    List<ActorDto>  getAllBySerial(long id);

    @Query(value = "select  a.id as id,a.born as born,a.name as name,a.imageUrl as imageUrl," +
            " a.almaMater as almaMater from Actor a where a.almaMater = :ss")
    List<ActorDto> getAllbbb(String ss);

//    Long getId();
//    Date getBorn();
//    String getName();
//    String getImageUrl();
//    String getAlmaMater();
//    List<String> getAwards();
//    String getWikiUrl();
//    String getShortAboutActor();


}
