package com.example.testingproject.model;

public class Pista {
    private String direction;
    private int length, id;

    public Pista(int id, int length, String direction){
        this.id = id;
        this.length = length;
        this.direction = direction;
    }


    public int getId(){
        return this.id;
    }

    public int getLength(){
        return this.length;

    }

    public String getDirection(){
        return this.direction;
    }











}
