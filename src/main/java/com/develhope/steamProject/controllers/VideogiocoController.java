package com.develhope.steamProject.controllers;

import com.develhope.steamProject.entities.Videogioco;
import com.develhope.steamProject.services.VideogiocoService;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.QueryParameterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("videogioco")
public class VideogiocoController {

    @Autowired
    private VideogiocoService videogiocoService;

    @GetMapping("search")
    public List<Videogioco> getVideogioco(@RequestParam(required = false)String titolo, @RequestParam(required = false)String genere, HttpServletResponse response, @RequestParam(required = true)int page, @RequestParam(required = true)int size) {
        List<Videogioco> risultati = new ArrayList<>();
        if(titolo == null) {
            risultati = videogiocoService.getVideogiochiGenere(genere, page, size);
        } else if (genere == null) {
            risultati = videogiocoService.getVideogiochiTitolo(titolo, page, size);
        } else {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
            throw new QueryParameterException("Inserire il nome o il titolo");
        }
        if(risultati.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_CONFLICT);
        }
        return risultati;
    }

}
