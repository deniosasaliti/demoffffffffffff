package com.example.demo.Entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Serials {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    private String original_name;

    private String rating;

    private String status;

    private String start_of_filming;

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
    private List<String > painters;

    private Date premiere;

    private String image_url;

    private String youtube_trailer_url;

    @Column(columnDefinition="TEXT")
    private String description;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Serials serials = (Serials) o;
        return id != null && Objects.equals(id, serials.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
