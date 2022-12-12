package com.develhope.steamProject.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "utente")
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nickname;
    private String nome;
    private String cognome;

    private String password;
    private String indirizzo;
    private LocalDate dataNascita;
    private float saldo;
    private boolean guest;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLibreria", referencedColumnName = "id")
    private Libreria libreria;

    @OneToOne(mappedBy = "utente")
    private Acquisto acquisto;

    @OneToMany(mappedBy = "utente")
    private List <Feedback> feedback;

}
