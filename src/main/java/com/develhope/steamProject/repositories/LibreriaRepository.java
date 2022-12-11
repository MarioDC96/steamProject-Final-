package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Libreria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibreriaRepository extends JpaRepository <Libreria, Long> {
}
