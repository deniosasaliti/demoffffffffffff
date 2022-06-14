package com.example.demo.Dto;

import com.example.demo.Entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.JoinColumn;
import java.time.Instant;
import java.util.Date;
import java.util.List;



public interface ActorDto {

     Long getId();
     Date getBorn();
     String getName();
     String getImageUrl();
     String getAlmaMater();
     List<String> getAwards();
     String getWikiUrl();
     String getShortAboutActor();
     List<SerialNameSlimDto> getSerial();



}
