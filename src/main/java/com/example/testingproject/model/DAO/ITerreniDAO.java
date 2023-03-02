package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Aereo;
import com.example.testingproject.model.Hangar;
import com.example.testingproject.model.Sosta;

import java.util.ArrayList;

public interface ITerreniDAO {
    public Hangar getTerrenoByID(int id);
    public  ArrayList<Hangar> getTerreni();
    public   ArrayList<Sosta> getSoste(int id);
    public  ArrayList<Aereo> getAerei() ;
    public  boolean insertSosta(Sosta sosta);
    public  boolean increaseHangar(int id) ;
    public  boolean decreaseHangar(int id);

    public  boolean removeSosta(Sosta sosta);







    }
