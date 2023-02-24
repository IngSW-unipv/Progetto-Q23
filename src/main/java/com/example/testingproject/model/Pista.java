package com.example.testingproject.model;

public class Pista {
    private String direction;
    private Integer length, id;

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
