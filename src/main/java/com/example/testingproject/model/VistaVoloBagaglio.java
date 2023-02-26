package com.example.testingproject.model;

public class VistaVoloBagaglio {

    int idVolo;
    String aeroportoP;
    String aeroportoA;

    public VistaVoloBagaglio(int idVolo, String aeroportoP, String aeroportoA) {
        this.idVolo = idVolo;
        this.aeroportoP = aeroportoP;
        this.aeroportoA = aeroportoA;
    }

    public int getIdVolo() {
        return idVolo;
    }

    public String getAeroportoP() {
        return aeroportoP;
    }

    public String getAeroportoA() {
        return aeroportoA;
    }

}
