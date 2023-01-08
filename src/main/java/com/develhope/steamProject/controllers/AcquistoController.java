package com.develhope.steamProject.controllers;

import com.develhope.steamProject.services.AcquistoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("acquisto")
public class AcquistoController {

    @Autowired
    AcquistoService acquistoService;

    @PostMapping("")
    public HttpStatus acquisto(@RequestParam long idUtente, @RequestParam long idVideogioco) {
        return acquistoService.acquisto(idUtente, idVideogioco);
    }
}
