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

    public void setIdVolo(int idVolo) {
        this.idVolo = idVolo;
    }

    public String getAeroportoP() {
        return aeroportoP;
    }

    public void setAeroportoP(String aeroportop) {
        this.aeroportoP = aeroportop;
    }

    public String getAeroportoA() {
        return aeroportoA;
    }

    public void setAeroportoA(String aeroportoA) {
        this.aeroportoA = aeroportoA;
    }
}
