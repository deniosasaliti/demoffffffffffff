package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AudioTrack {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String  name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Serial serial;
}
