package com.develhope.steamProject.entities;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    private LocalDate dataAcquisto;
    private boolean disponibile;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idvideogioco", referencedColumnName = "id")
    private Videogioco videogioco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idutente", referencedColumnName = "id")
    private Utente utente;
}
