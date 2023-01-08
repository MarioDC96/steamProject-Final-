package com.develhope.steamProject.services;
import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.entities.Videogioco;
import org.springframework.http.HttpStatus;

import java.util.List;


public interface IUtenteService {

    Utente getUtenteSingle(String nickname, String titolo);
    public HttpStatus deleteGames(Long idutente, Long idVideogioco);

    public List<Videogioco> getPersonalGames(Long idUtente);

}
