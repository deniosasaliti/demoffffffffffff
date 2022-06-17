package com.example.demo.Dto.Actor;

import com.example.demo.Dto.Serial.SerialNameSlimDto;

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
