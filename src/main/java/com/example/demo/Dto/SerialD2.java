package com.example.demo.Dto;

import com.example.demo.Entity.Actor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter


public class SerialD2 {
 private    Long id;
 private    String originalName;
 private List<AudioD2> audioTracks;
 private List<ActorDto> actors;

 public SerialD2(Long id, String originalName) {
  this.id = id;
  this.originalName = originalName;
 }
}
