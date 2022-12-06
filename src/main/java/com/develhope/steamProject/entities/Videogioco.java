package com.develhope.steamProject.entities;

import com.develhope.steamProject.entities.enumerations.Divieto;
import com.develhope.steamProject.entities.enumerations.Genere;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.time.Year;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "videogioco")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Videogioco {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String titolo;
    private float prezzo;
    private String casaProduttrice;
    private Year annoUscita;
    private String generi;
    private String divieti;
    private String trailer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Videogioco that = (Videogioco) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }



}
