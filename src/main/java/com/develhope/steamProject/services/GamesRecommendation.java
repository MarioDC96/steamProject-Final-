package com.develhope.steamProject.services;

import com.develhope.steamProject.entities.Recommendation;
import com.develhope.steamProject.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GamesRecommendation {

    private Map<String, Map<String, Double>> ratings;
    private Map<String, Double> averageRatings;

    public GamesRecommendation(Map<String, Map<String, Double>> ratings) {
        this.ratings = ratings;
        this.averageRatings = computeAverageRatings();
    }


    @Autowired
    private FeedbackRepository feedbackRepository;

    private Map<String, Double> computeAverageRatings() {
        // Calcola le valutazioni medie per ogni film utilizzando i dati di valutazione
        // e restituisci una mappa che associa ad ogni film il suo rating medio
        return feedbackRepository.averageRatings();

    }

    public List<String> recommendGames(String user) {
        List<Recommendation> recommendations = new ArrayList<>();
        Map<String, Double> userRatings = ratings.get(user);

        for (String videogicoTitle : ratings.keySet()) {
            // Salta il film se l'utente l'ha già valutato
            if (userRatings.containsKey(videogicoTitle)) {
                continue;
            }

            double recommendationScore = 0.0;
            double totalWeight = 0.0;

            for (String ratedGames : userRatings.keySet()) {
                double ratingDifference = ratings.get(videogicoTitle).get(ratedGames) - averageRatings.get(ratedGames);
                double weight = 1.0 / (1.0 + Math.abs(ratingDifference));

                recommendationScore += weight * userRatings.get(ratedGames);
                totalWeight += weight;
            }

            recommendations.add(new Recommendation(videogicoTitle,recommendationScore / totalWeight));
        }

        // Ordina la lista di raccomandazioni in base al punteggio di raccomandazione e restituisci
        // i primi 3 elementi della lista
        return recommendations.stream()
                .sorted(Comparator.comparing(Recommendation::getVoto).reversed())
                .map(Recommendation::getvideogiocoTitle)
                .limit(3)
                .collect(Collectors.toList());
    }
}
