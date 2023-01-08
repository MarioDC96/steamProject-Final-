package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Acquisto;
import com.develhope.steamProject.entities.Videogioco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AcquistoRepository extends JpaRepository<Acquisto, Long> {
    @Query(value = "SELECT * FROM acquisto  WHERE acquisto.idutente = ?1", nativeQuery = true)
    List<Acquisto> findPurchaseByUtente(Long idUtente);
    @Query(value = "SELECT * FROM acquisto  WHERE acquisto.idvideogioco = ?1", nativeQuery = true)
    List<Acquisto> findPurchaseByIdGames(Long idvideogioco);

}
