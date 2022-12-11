package com.develhope.steamProject.services;
import com.develhope.steamProject.entities.Utente;
import java.util.List;


public interface IUtenteService {

    List<Utente> getUtenteSingle(String nickname, String titolo);

}
