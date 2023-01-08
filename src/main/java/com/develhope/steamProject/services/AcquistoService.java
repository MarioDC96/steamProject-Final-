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
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AcquistoService implements IAcquistoService{

    @Autowired
    VideogiocoRepository videogiocoRepository;

    @Autowired
    AcquistoRepository acquistoRepository;

    @Autowired
    UtenteRepository utenteRepository;

    @Override
    public HttpStatus acquisto(long idUtente, long idVideogioco) {
        Optional<Utente> optionalUtente = utenteRepository.findById(idUtente);
        if (optionalUtente.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        Utente utente = optionalUtente.get();
        List<Acquisto> acquisti = acquistoRepository.findPurchaseByUtente(idUtente);
        Optional<Videogioco> optionalVideogioco = videogiocoRepository.findById(idVideogioco);
        if (optionalVideogioco.isEmpty()) {
            return HttpStatus.BAD_REQUEST;
        }
        Videogioco videogioco = optionalVideogioco.get();
        Videogioco videogiocoDaAcquistare = getVideogiocoDaAcquistare(acquisti, videogioco);
        if(videogiocoDaAcquistare == null) {
            return HttpStatus.BAD_REQUEST;
        }
        if (utente.isLogged()) {
            if (utente.getSaldo() - videogioco.getPrezzo() < 0) {
                return HttpStatus.CONFLICT;
            }
            utente.setSaldo(utente.getSaldo() - videogioco.getPrezzo());
            Acquisto acquisto = new Acquisto();
            acquisto.setUtente(utente);
            acquisto.setDataAcquisto(Date.valueOf(LocalDate.now()));
            acquisto.setVideogioco(videogioco);
            acquisto.setCosto(videogioco.getPrezzo());
            acquisto.setDisponibile(true);
            acquistoRepository.saveAndFlush(acquisto);
            utenteRepository.save(utente);
        } else {
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.OK;
    }

    private Videogioco getVideogiocoDaAcquistare(List<Acquisto> acquisti, Videogioco videogioco) {
        for (Acquisto acquisto: acquisti) {
            if(acquisto.getVideogioco().equals(videogioco)) {
                return null;
            }
        }
        return videogioco;
    }
}
