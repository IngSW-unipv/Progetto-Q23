package com.example.testingproject.model;

public class Hangar {
    private int id;
    private int nposti;
    private int npostiLiberi;

    public Hangar(int id, int nposti, int npostiLiberi) {
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
