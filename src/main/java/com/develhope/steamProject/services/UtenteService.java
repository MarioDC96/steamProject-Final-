package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Acquisto;
import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.entities.Videogioco;
import com.develhope.steamProject.repositories.AcquistoRepository;
import com.develhope.steamProject.repositories.UtenteRepository;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UtenteService implements IUtenteService{


    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AcquistoRepository acquistoRepository;

    public Utente getUtenteSignIn (Utente utente){
        return utenteRepository.saveAndFlush(utente);
    }

    @Override
    public Utente getUtenteSingle(String nickname, String password) {
       Optional<Utente> utenteOptional = utenteRepository.getUtenteByNicknameAndPassword(nickname, password);
       return utenteOptional.orElse(null);
    }


    //Deve essere gestito il caso in cui i parametri idutente e idVideogioco siano nulli.
    public HttpStatus deleteGames(Long idutente, Long idVideogioco) {
        Acquisto acquisto = acquistoRepository.getReferenceById(idVideogioco);
        Utente utente = utenteRepository.getReferenceById(idutente);
        if (utente.isLogged() && acquisto.isDisponibile() && utente.getId() == idutente && acquisto.getId() == idVideogioco) {
            acquisto.setDisponibile(false);
            acquistoRepository.saveAndFlush(acquisto);
            HttpStatus httpStatus = HttpStatus.OK;
            return httpStatus;
        } else {
            throw new QueryParameterException("Videogioco non disponibile nella libreria dell'utente o Utente non registrato ");
        }
    }

    public List<Videogioco> getPersonalGames(Long idUtente){
        List <Acquisto> acqusiti = acquistoRepository.findPurchaseByUtente(idUtente);
        Utente utente = utenteRepository.getReferenceById(idUtente);
        if(!acqusiti.isEmpty() && utente.isLogged() ) {
            List<Videogioco> mygames = new ArrayList<>();
            for(Acquisto a : acqusiti){
                if(a.isDisponibile()){
                    mygames.add(a.getVideogioco());
                }
            }
            return mygames;
        }else{
            throw new QueryParameterException("Untente non registrato o non ha svolto acquisti");
        }
    }
}
