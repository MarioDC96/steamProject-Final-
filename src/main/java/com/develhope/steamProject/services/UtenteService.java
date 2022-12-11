package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.repositories.UtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UtenteService implements IUtenteService{


    @Autowired
    private UtenteRepository utenteRepository;


    @Override
    public List <Utente> getUtenteSingle(String nickname, String password) {
       return utenteRepository.getUtenteByFilter(nickname, password);

    }
}
