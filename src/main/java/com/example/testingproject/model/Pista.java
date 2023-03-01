package com.example.testingproject.model;

public class Pista {
    private final String direction;
    private final Integer length;
    private final Integer id;

    public Pista(Integer id, Integer length, String direction){
        this.id = id;
        this.length = length;
        this.direction = direction;
    }


    public Integer getId(){
        return this.id;
    }

    public Integer getLength(){
        return this.length;

    }

    public String getDirection(){
        return this.direction;
    }











}
