package com.example.testingproject.model;

public class Wind {
    private String[] possibleDirections = {"N","E","W","S"};

    public String getDirection(){
        int index = (int)(Math.random()*5);
        return possibleDirections[index];

    }

}
