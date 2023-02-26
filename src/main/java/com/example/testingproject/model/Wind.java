package com.example.testingproject.model;

public class Wind {
    private String[] possibleDirections = {"N","E","W","S"};

    public String getDirectionIndex(){
        int index = (int)(Math.random()*4);
        return possibleDirections[index];

    }

    public String getDirection(){
        String direction = getDirectionIndex();

        if(direction.equals("E")){
            return "Est";
        }
        else if(direction.equals("W")){
            return "Ovest";
        }
        else if(direction.equals("N")){
            return "Nord";
        }else{
            return "Sud";
        }
    }

    }


