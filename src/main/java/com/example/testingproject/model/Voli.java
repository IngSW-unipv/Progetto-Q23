package com.example.testingproject.model;

//singleton per istanza di account

import java.lang.constant.Constable;

public class Voli {
    private String gate,nome_aereo;
    private int id,durata,ritardo,aereo;


    public Voli(String gate, String nome_aereo,int id,int durata,int ritardo,int aereo) {
        this.gate = gate;
        this.nome_aereo = nome_aereo;
        this.id=id;
        this.durata=durata;
        this.ritardo=ritardo;
        this.aereo=aereo;
    }

    public String getGate() {
        return this.gate;
    }

    public String getNome_aereo() {
        return nome_aereo;
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
}



