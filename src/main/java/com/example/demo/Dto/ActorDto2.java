package com.example.demo.Dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ActorDto2 {

    private long id;
    private String name;
    List<SerialD2> serials;

    public ActorDto2(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
