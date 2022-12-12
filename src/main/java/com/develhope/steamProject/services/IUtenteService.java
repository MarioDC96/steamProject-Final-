package com.develhope.steamProject.services;
import com.develhope.steamProject.entities.Utente;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface IUtenteService {

    List<Utente> getUtenteSingle(String nickname, String titolo);
    public HttpStatus deleteGames(Long idutente, Long idVideogioco);

}
