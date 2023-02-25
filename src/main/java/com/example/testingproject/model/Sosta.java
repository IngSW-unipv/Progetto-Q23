package com.example.testingproject.model;

public class Sosta {

    private int Hangar,Aereo;
    private String Inizio,Fine;

    public Sosta(int hangar, int aereo, String inizio, String fine) {
        this.Hangar = hangar;
        this.Aereo = aereo;
        this.Inizio = inizio;
        this.Fine = fine;
    }
    public int getHangar() {
        return Hangar;
    }

    public void setHangar(int hangar) {
        this.Hangar = hangar;
    }

    public int getAereo() {
        return Aereo;
    }

    public void setAereo(int aereo) {
        this.Aereo = aereo;
    }

    public String getInizio() {
        return Inizio;
    }

    public void setInizio(String inizio) {
        this.Inizio = inizio;
    }

    public String getFine() {
        return Fine;
    }

    public void setFine(String fine) {
        this.Fine = fine;
    }

}
