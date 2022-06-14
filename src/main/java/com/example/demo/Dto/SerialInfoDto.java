package com.example.demo.Dto;






import com.example.demo.Entity.AudioTrack;

import java.util.List;

public interface  SerialInfoDto {

    Long getId();
    String getDescription();
//    String getImageUrl();
//    String getOriginalName();
//    Date getPremiere();
//    String getRating();
//    String getStartOfFilming();
//    String getStatus();
//    String getYoutubeTrailerUrl();

      List<AudioTrack> getAudioTracks();






}
