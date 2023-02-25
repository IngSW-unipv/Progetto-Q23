package com.example.testingproject.model.service;

import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.Pista;

import java.sql.SQLException;
import java.util.ArrayList;

public class PistaService {
    private PistaDAO pistaDAO = new PistaDAO();

    public ArrayList<Pista> getPiste() throws SQLException {
        ArrayList<Pista> piste = new ArrayList<Pista>();
        try {
            piste = pistaDAO.findPiste();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;

        }

        return piste;


    }

    public Pista getPistaByID(Integer id) throws SQLException {
        try {
            Pista pista = pistaDAO.findPistaByID(id);
            return pista;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }


    public void addPista(Pista pista) throws SQLException {
        try {
            pistaDAO.newPista(pista);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}




