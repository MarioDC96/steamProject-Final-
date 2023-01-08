package com.develhope.steamProject.entities;

public class Recommendation {

    private String videogiocoTitle;
    private double voto;

    public Recommendation(String videogiocoTitle, double voto) {
        this.videogiocoTitle = videogiocoTitle;
        this.voto = voto;
    }

    public String getvideogiocoTitle() {
        return videogiocoTitle;
    }

    public double getVoto() {
        return voto;
    }
}
