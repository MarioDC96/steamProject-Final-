package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Videogioco;
import com.develhope.steamProject.repositories.VideogiocoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class VideogiocoService implements IVideogiocoService{

    @Autowired
    private VideogiocoRepository videogiocoRepository;
    @Override
    public void createVideogioco(Videogioco videogioco) {
        videogiocoRepository.saveAndFlush(videogioco);
    }

    @Override
    public HttpStatus deleteVideogioco(Long id) {
        if(videogiocoRepository.existsById(id)) {
            return HttpStatus.CONFLICT;
        }
        videogiocoRepository.deleteById(id);
        return HttpStatus.OK;
    }

    @Override
    public Collection<Videogioco> getVideogiochi() {
        return videogiocoRepository.findAll();
    }

    @Override
    public Optional<Videogioco> getVideogioco(Long id) {
        return videogiocoRepository.findById(id);
    }

    @Override
    public List<Videogioco> getVideogiochiTitolo(String titolo) {
        return videogiocoRepository.findByTitoloLike(titolo);
    }

    @Override
    public List<Videogioco> getVideogiochiGenere(String genere) {
        return videogiocoRepository.findByGeneriLike(genere);
    }

}
