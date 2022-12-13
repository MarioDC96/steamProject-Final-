package com.develhope.steamProject.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
@Entity
@Data
@Table(name = "acquisto")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Acquisto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private float costo;
    private Year dataAcquisto;
    private boolean disponibile;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idvideogioco", referencedColumnName = "id")
    private Videogioco videogioco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idutente", referencedColumnName = "id")
    private Utente utente;
}
