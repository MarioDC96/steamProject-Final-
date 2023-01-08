package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Map;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

    @Query(value = "SELECT EXISTS(SELECT * FROM feedback  WHERE feedback.id_videogioco = ?1 AND feedback.idutente = ?2)", nativeQuery = true)
     int ifExist(Long idvideogioco, Long idutente);

    @Query(value = "SELECT videogioco.titolo, AVG(voto) FROM videogioco INNER JOIN feedback ON feedback.id_videogioco = videogioco.id  GROUP BY videogioco.titolo",nativeQuery = true)
    Map<String, Double> averageRatings();
}
