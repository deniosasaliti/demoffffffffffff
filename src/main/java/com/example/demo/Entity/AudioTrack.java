package com.example.demo.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
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
    private Serial serial;
}
