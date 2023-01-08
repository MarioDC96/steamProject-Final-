package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Acquisto;
import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.entities.Videogioco;
import com.develhope.steamProject.repositories.AcquistoRepository;
import com.develhope.steamProject.repositories.UtenteRepository;
import com.develhope.steamProject.repositories.VideogiocoRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AcquistoService implements IAcquistoService{

    @Autowired
    VideogiocoRepository videogiocoRepository;

    @Autowired
    AcquistoRepository acquistoRepository;

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public HttpStatus acquisto(long idUtente, long idVideogioco) {
        Optional<Acquisto> optionalAcquisto = acquistoRepository.findPurchaseByUtenteAndVideogioco(idUtente, idVideogioco);
        Optional<Utente> optionalUtente = utenteRepository.findById(idUtente);
        if (optionalUtente.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        Utente utente = optionalUtente.get();
        Optional<Videogioco> optionalVideogioco = videogiocoRepository.findById(idVideogioco);
        if (optionalVideogioco.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        Videogioco videogioco = optionalVideogioco.get();
        if (utente.isLogged() && (optionalAcquisto.isEmpty() || !optionalAcquisto.get().isDisponibile())) {
            if (utente.getSaldo() - videogioco.getPrezzo() < 0) {
                return HttpStatus.CONFLICT;
            }
            utente.setSaldo(utente.getSaldo() - videogioco.getPrezzo());
            Acquisto acquisto = new Acquisto();
            acquisto.setUtente(utente);
            acquisto.setDataAcquisto(LocalDate.now());
            acquisto.setVideogioco(videogioco);
            acquisto.setCosto(videogioco.getPrezzo());
            acquisto.setDisponibile(true);
            acquistoRepository.saveAndFlush(acquisto);
            utenteRepository.saveAndFlush(utente);
        } else {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }
}
