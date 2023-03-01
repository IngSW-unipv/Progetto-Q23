package com.example.testingproject.model;

//singleton per istanza di account

import java.lang.constant.Constable;

public class Voli {
    private final String gate;
    private final String aeroportop;
    private final String dataora;
    private final int id;
    private final int durata;
    private final int ritardo;
    private final int aereo;
    private final int pista;


    public Voli(String gate, String aeroportop, String dataora, int id, int durata, int ritardo, int aereo, int pista) {
        this.gate = gate;
        this.aeroportop = aeroportop;
        this.dataora = dataora;
        this.id = id;
        this.durata = durata;
        this.ritardo = ritardo;
        this.aereo = aereo;
        this.pista = pista;
    }


    public String getGate() {
        return gate;
    }

    public String getAeroportop() {
        return aeroportop;
    }

    public String getDataora() {
        return dataora;
    }

    public int getId() {
        return id;
    }

    public int getDurata() {
        return durata;
    }

    public int getRitardo() {
        return ritardo;
    }

    public int getAereo() {
        return aereo;
    }

    public int getPista() {
        return pista;
    }
}



