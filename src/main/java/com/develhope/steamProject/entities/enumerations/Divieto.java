package com.develhope.steamProject.entities.enumerations;

public enum Divieto {
    FUMO("Fumo"),
    ALCOL("Alcol"),
    DROGA("Droga"),
    SESSO("Sesso"),
    LINGUAGGIOSCURRILE("LinguaggioScurrile");

    private final String divieto;

    Divieto(String divieto) {
        this.divieto = divieto;
    }

    public String getDivieto() {
        return divieto;
    }
}
