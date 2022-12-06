package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Videogioco;
import org.springframework.http.HttpStatus;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface IVideogiocoService {
    void createVideogioco(Videogioco videogioco);
    default void updateProduct(Long id, Videogioco videogioco) {}
    HttpStatus deleteVideogioco(Long id);
    Collection<Videogioco> getVideogiochi();
    Optional<Videogioco> getVideogioco(Long id);
    List<Videogioco> getVideogiochiTitolo(String titolo);
    List<Videogioco> getVideogiochiGenere(String genere);

}
