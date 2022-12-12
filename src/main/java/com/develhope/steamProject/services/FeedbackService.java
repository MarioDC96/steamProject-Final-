package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Acquisto;
import com.develhope.steamProject.entities.Feedback;
import com.develhope.steamProject.entities.Utente;
import com.develhope.steamProject.entities.Videogioco;
import com.develhope.steamProject.repositories.AcquistoRepository;

import com.develhope.steamProject.repositories.FeedbackRepository;
import com.develhope.steamProject.repositories.UtenteRepository;

import com.develhope.steamProject.repositories.VideogiocoRepository;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
public class FeedbackService implements IFeedbackService{

    @Autowired
    private UtenteRepository utenteRepository;

    @Autowired
    private AcquistoRepository acquistoRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private VideogiocoRepository videogiocoRepository;



    @Override
    public HttpStatus insertFeedback(Long idutente, Long idvideogioco, int voto, String commento){
       Utente utente = utenteRepository.getReferenceById(idutente);
       Acquisto acquisto = acquistoRepository.getReferenceById(idvideogioco);
       if(!utente.isGuest() && acquisto != null ){
           Feedback feedback = new Feedback();
           feedback.setVoto(voto);
           feedback.setCommento(commento);
           feedback.setUtente(utente);
           Videogioco videogioco = videogiocoRepository.getReferenceById(idvideogioco);
           feedback.setVideogioco(videogioco);
           feedbackRepository.saveAndFlush(feedback);
           HttpStatus httpStatus = HttpStatus.OK;
           return httpStatus;
       }else {
           throw new QueryParameterException("Videogioco non acquistato, non puoi recensirlo oppure utente non registrato");
       }
    }


}
