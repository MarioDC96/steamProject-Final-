package com.develhope.steamProject.entities.enumerations;

public enum Genere {
    SPARATUTTO("Sparatutto"),
    HORROR("Horror"),
    GDR("GDR"),
    FPS("FPS"),
    TPS("TPS"),
    OPENWORLD("OpenWorld");

    private final String genere;

    Genere(String genere) {
        this.genere = genere;
    }

    public String getGenere() {
        return genere;
    }
}
