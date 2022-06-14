package com.example.demo.service;
import com.example.demo.Dto.ActorDto;
import com.example.demo.Dto.AudioD2;
import com.example.demo.Dto.SerialD2;
import com.example.demo.Entity.Actor;
import com.example.demo.Entity.Serial;
import com.example.demo.repos.ActorRepository;
import com.example.demo.repos.AudiRepository;
import com.example.demo.repos.SerialRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SerialService {

    final SerialRepository serialRepository;
    final AudiRepository audiRepository;
    final ActorRepository actorRepository;


    public SerialService(SerialRepository serialRepository, AudiRepository audiRepository, ActorRepository actorRepository) {
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




}
