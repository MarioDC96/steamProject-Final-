package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT EXISTS(SELECT * FROM feedback  WHERE feedback.id_videogioco = ?1 AND feedback.idutente = ?2)", nativeQuery = true)
     int ifExist(Long idvideogioco, Long idutente);
}
