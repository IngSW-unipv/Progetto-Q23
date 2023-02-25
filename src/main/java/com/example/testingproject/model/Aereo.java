package com.example.testingproject.model;

public class Aereo {
    private int id,caricoMax;
    private String modello;



    public Aereo(int id, int caricoMax, String modello) {
        this.id = id;
        this.caricoMax = caricoMax;
        this.modello = modello;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCaricoMax() {
        return caricoMax;
    }

    public void setCaricoMax(int caricoMax) {
        this.caricoMax = caricoMax;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }
}
