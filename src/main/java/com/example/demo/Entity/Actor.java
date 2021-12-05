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
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date born;
    private String image_url;
    private String Occupation;
    private String alma_mater;
    @ElementCollection()
    @CollectionTable(name = "award", joinColumns = @JoinColumn(name = "actor_id"))
    private List<String> awards;
    private String wiki_url;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Actor actor = (Actor) o;
        return id != null && Objects.equals(id, actor.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
