package com.example.demo.service.impl;
import com.example.demo.Dto.Actor.ActorDto;
import com.example.demo.Dto.Audio.AudioD2;
import com.example.demo.Dto.Serial.SerialD2;
import com.example.demo.Dto.Serial.SerialFrontPageInfo;
import com.example.demo.repos.ActorRepository;
import com.example.demo.repos.AudiRepository;
import com.example.demo.repos.SerialRepository;
import com.example.demo.service.SerialService;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SerialServiceImpl implements SerialService {

    final SerialRepository serialRepository;
    final AudiRepository audiRepository;
    final ActorRepository actorRepository;


    public SerialServiceImpl(SerialRepository serialRepository, AudiRepository audiRepository, ActorRepository actorRepository) {
        this.serialRepository = serialRepository;
        this.audiRepository = audiRepository;

        this.actorRepository = actorRepository;
    }

    @Transactional
    public SerialD2 getSerialByIdFetchAudios(long serialId){
        List<AudioD2> audiosSlim = audiRepository.getSlimOfAllAudiosBySerialId(serialId);

        SerialD2 serialSlim = serialRepository.getSlimOfSerialById(serialId);

        List<ActorDto> allBySerial = actorRepository.getAllBySerial(serialSlim.getId());
        serialSlim.setActors(allBySerial);
        serialSlim.setAudioTracks(audiosSlim);
        return serialSlim;
    }

    @Transactional
    public List<SerialFrontPageInfo> getAllSerialsByUserId(long id){
        return serialRepository.getAllSerialsByUserId(id);
    }







}
