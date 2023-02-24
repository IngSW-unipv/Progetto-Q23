package com.example.testingproject.model;

public class Terreno {
    public int id;
    public int nposti;
    public int npostiLiberi;

    public Terreno(int id, int nposti, int npostiLiberi) {
        this.id = id;
        this.nposti = nposti;
        this.npostiLiberi = npostiLiberi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNposti() {
        return nposti;
    }

    public void setNposti(int nposti) {
        this.nposti = nposti;
    }

    public int getNpostiLiberi() {
        return npostiLiberi;
    }

    public void setNpostiLiberi(int npostiliberi) {
        this.npostiLiberi = npostiliberi;
    }



}
