package com.develhope.steamProject.controllers;

import com.develhope.steamProject.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;



    @PutMapping("feedback")
    public HttpStatus insertFeedback(@RequestParam Long idutente,@RequestParam Long idvideogioco,@RequestParam int voto, @RequestParam String commento){
        return feedbackService.insertFeedback(idutente,idvideogioco,voto,commento);
    }
}
