package com.example.demo.MapStructMapper;

import com.example.demo.Entity.Serial;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SerialMapper {

    SerialMapper INSTANCE = Mappers.getMapper(SerialMapper.class);


}
