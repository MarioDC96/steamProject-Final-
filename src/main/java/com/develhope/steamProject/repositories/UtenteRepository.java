package com.develhope.steamProject.repositories;


import com.develhope.steamProject.entities.Utente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface UtenteRepository extends JpaRepository <Utente, Long> {

    @Query(value = "SELECT * FROM utente  WHERE utente.nickname = ?1 AND utente.password = ?2", nativeQuery = true)
    List<Utente> getUtenteByFilter( String nickname, String password);
}
