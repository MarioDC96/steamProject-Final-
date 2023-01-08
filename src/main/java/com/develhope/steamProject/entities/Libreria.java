package com.develhope.steamProject.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name = "libreria")
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Libreria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "libreria")
    @JoinColumn(name = "idUtente", referencedColumnName = "id")
    @JsonIgnore
    private Utente utente;
}
