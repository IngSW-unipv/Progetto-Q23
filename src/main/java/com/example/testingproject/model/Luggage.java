package com.example.testingproject.model;

public class Luggage{
    public int Volo,Peso;
    public String Stato;

    public Luggage(int volo, int peso, String stato) {
        Volo = volo;
        Peso = peso;
        Stato = stato;
    }

    public int getPeso() {
        return Peso;
    }

    public void setPeso(int peso) {
        Peso = peso;
    }

    public String getStato() {
        return Stato;
    }

    public void setStato(String stato) {
        Stato = stato;
    }

    public int getVolo() {
        return Volo;
    }

    public void setVolo(int volo) {
        Volo = volo;
    }
}
