package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Videogioco;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VideogiocoRepository extends JpaRepository<Videogioco, Long> {

    @Query("select v from Videogioco v where v.titolo like %?#{[0].toUpperCase()}%")
    List<Videogioco> findByTitoloLike(String titolo, Pageable pageable);

    @Query("select v from Videogioco v where v.generi like %?#{[0].toUpperCase()}%")
    List<Videogioco> findByGeneriLike(String generi, Pageable pageable);
}

