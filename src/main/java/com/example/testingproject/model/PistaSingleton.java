package com.example.testingproject.model;

import com.example.testingproject.model.DAO.PistaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class PistaSingleton {
    //istanza singleton della lista di piste

    private ArrayList<Pista> Piste = null;

    private PistaDAO pistaDAO;

    private static PistaSingleton instance = new PistaSingleton();

    private PistaSingleton() {
        pistaDAO = new PistaDAO();
    }

    public static PistaSingleton getInstance() {
        if (instance == null) {
            instance = new PistaSingleton();
        }
        return instance;
    }

    public ArrayList<Pista> getPiste() throws SQLException {
        if(Piste == null){
            Piste = pistaDAO.findPiste();
        }
        return Piste;
    }



}
