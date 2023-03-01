package com.example.testingproject.model;

public class Luggage {
    public int volo, peso, id;
    public String stato;

    public Luggage(int Id, int Peso, String Stato, int Volo) {
        volo = Volo;
        peso = Peso;
        stato = Stato;
        id = Id;
    }
    public int getPeso() {
        return peso;
    }
    public String getStato() {
        return stato;
    }
    public int getVolo() {
        return volo;
    }
    public int getId() {
        return id;
    }
}