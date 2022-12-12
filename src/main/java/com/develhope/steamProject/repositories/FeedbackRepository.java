package com.develhope.steamProject.repositories;

import com.develhope.steamProject.entities.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
