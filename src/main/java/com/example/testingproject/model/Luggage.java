package com.example.testingproject.model;

public class Luggage{
    public int Volo,Peso,Id;
    public String Stato;

    public Luggage(int id, int peso, String stato, int volo) {
        Volo = volo;
        Peso = peso;
        Stato = stato;
        Id = id;
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

    public int getId() {
        return Id;
    }


    public void setVolo(int volo) {
        Volo = volo;
    }

}
