package com.example.testingproject.model;

public class Wind {


    public String getDirectionIndex(){
        final String[] possibleDirections = {"N","E","W","S"};
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


