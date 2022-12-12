package com.develhope.steamProject.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "feedback")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Feedback {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private int voto;
    private String commento;

    @ManyToOne
    @JoinColumn(name = "idutente", referencedColumnName = "id")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "idVideogioco", referencedColumnName = "id")
    private Videogioco videogioco;
}
