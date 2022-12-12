package com.develhope.steamProject.entities;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idVideogioco", referencedColumnName = "id")
    private Videogioco videogioco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idutente", referencedColumnName = "id")
    private Utente utente;
}
