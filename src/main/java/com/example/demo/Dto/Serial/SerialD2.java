package com.example.demo.Dto.Serial;

import com.example.demo.Dto.Actor.ActorDto;
import com.example.demo.Dto.Audio.AudioD2;
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
