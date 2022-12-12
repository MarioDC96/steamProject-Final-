package com.develhope.steamProject.services;

import org.springframework.http.HttpStatus;


public interface IFeedbackService {

    HttpStatus insertFeedback(Long idutente, Long idvideogioco, int voto, String commento);

}
