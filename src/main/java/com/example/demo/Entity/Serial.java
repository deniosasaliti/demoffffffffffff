package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity

//@NamedEntityGraph(
//        name = "serial-entity-graph",
//        attributeNodes = {
//                @NamedAttributeNode("id"),
//                @NamedAttributeNode("audioTracks"),
//        }
//)
public class Serial  {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String originalName;

    private String status;

    private String startOfFilming;

    private Date premiere;

    private String imageUrl;

    private String youtubeTrailerUrl;

    @Column(columnDefinition="TEXT")
    private String description;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "serial")
    @JsonManagedReference
    private List<AudioTrack> audioTracks;




    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinTable(name = "serial_actor",
            joinColumns = @JoinColumn(name = "serial_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
//    @JsonManagedReference
    private Set<Actor> actors = new HashSet<>();

    @ElementCollection()
    @CollectionTable(name = "country", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> countries;

    @ElementCollection()
    @CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> genres;

    @ElementCollection()
    @CollectionTable(name = "director", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> directors;

    @ElementCollection()
    @CollectionTable(name = "scenario", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String > scenario;

    @ElementCollection()
    @CollectionTable(name = "producer", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> producers;

    @ElementCollection()
    @CollectionTable(name = "composer", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> composer;

    @ElementCollection()
    @CollectionTable(name = "painter", joinColumns = @JoinColumn(name = "serial_id"))
    private List<String> painters;

    @ManyToMany(mappedBy = "serials")
    private Set<User> users = new HashSet<>();

    @OneToOne(mappedBy = "serial",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private Rating rating;


    public void setRating(Rating rating){
        if (rating == null){

            if (this.rating !=null){
                this.rating.setSerial(null);
            }
        }else {
            rating.setSerial(this);
        }
        this.rating = rating;
    }







    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Serial serial = (Serial) o;
        return id != null && Objects.equals(id, serial.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addAudioTrack(AudioTrack audioTrack) {
        audioTracks.add(audioTrack);
        audioTrack.setSerial(this);
    }

    public void removeAudioTrack(AudioTrack audioTrack) {
        audioTracks.remove(audioTrack);
        audioTrack.setSerial(null);
    }
}
