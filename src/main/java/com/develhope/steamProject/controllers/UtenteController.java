package com.develhope.steamProject.controllers;


import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.services.UtenteService;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utente")
public class UtenteController {

    @Autowired
    private UtenteService utenteService;


    @GetMapping("login")
    public List <Utente> getUtenteByLogin(@RequestParam String nickname, @RequestParam String password, HttpServletResponse response){
        List<Utente> utente = utenteService.getUtenteSingle(nickname, password);
        if(utente.isEmpty()){
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            throw new QueryParameterException("Accesso Negato: nickname o password errata, se non hai un account registrati");
        }else {
            response.setStatus(HttpServletResponse.SC_ACCEPTED);
            return utente;
        }
    }
    @PutMapping("delete")
    public HttpStatus deleteGamesByUtente(@RequestParam Long idutente, @RequestParam Long idVideogioco){
        return utenteService.deleteGames(idutente,idVideogioco);
    }

}

