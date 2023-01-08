package com.develhope.steamProject.services;


import com.develhope.steamProject.entities.Videogioco;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IAcquistoService {

    HttpStatus acquisto(long idUtente, long idVideogioco);
}
