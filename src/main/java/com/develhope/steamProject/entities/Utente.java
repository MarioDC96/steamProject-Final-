package com.develhope.steamProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private boolean logged;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLibreria", referencedColumnName = "id")
    private Libreria libreria;

    @OneToMany(mappedBy = "utente")
    @JsonIgnore
    private List<Acquisto> acquisto;

    @OneToMany(mappedBy = "utente")
    @JsonIgnore
    private List <Feedback> feedback;

}
