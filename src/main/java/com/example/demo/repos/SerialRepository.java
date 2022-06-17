package com.example.demo.repos;

import com.example.demo.Dto.Serial.SerialD2;
import com.example.demo.Dto.Serial.SerialFrontPageInfo;
import com.example.demo.Dto.Serial.SerialInfoDto;
import com.example.demo.Entity.Actor;
import com.example.demo.Entity.Serial;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerialRepository extends JpaRepository<Serial,Long> {



    List<Serial> findByActors(Actor actor);

    Serial findSerialById(long id);

    SerialInfoDto findSerialInfoDtoById(long id);
    @Query(value = "select new com.example.demo.Dto.Serial.SerialD2(s.id,s.originalName) from Serial s where s.id = :id")
    SerialD2 getSlimOfSerialById(Long id);
    @Query("select new  com.example.demo.Dto.Serial.SerialD2(s.id,s.originalName) from Serial s left join Actor a  where a.id = :id")
    List<SerialD2> getListOfSerialSlimByActor(long id);
    @Query(value = "select s.id as id, s.status as status,s.originalName as originalName,s.imageUrl as imageUrl  from Serial s left join s.users u  where u.id = :id")
    List<SerialFrontPageInfo> getAllSerialsByUserId(long id);


    @Query(value = "select  s from Serial s left join s.users u where u.id = :id")
    List<Serial> getAllSerialsByUserIdAAA(long id);



    List<SerialFrontPageInfo> findAllBy(Pageable pageable);


    List<Serial> getByActors(Actor actor);


    <T> T findBy(long id, Class<T> type);

    List<SerialD2> findByOriginalName(String name);

    SerialD2 findSerialD2ById(Long id);
    @EntityGraph(attributePaths = {"id","audioTracks"})
    Serial findSerialById(Long id);

}
