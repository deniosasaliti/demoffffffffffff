package com.example.demo.Entity;

import com.example.demo.Entity.enums.RatingType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Rating {

    @Id
    private Long id;

    private int ImdbRating;
    private int KopilkaRating;
    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Serial serial;

}
