package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Pista;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IPistaDAO {


    public ArrayList<Pista> findPiste() throws SQLException;


    public Pista findPistaByID(Integer Id) throws SQLException;

    public boolean newPista(Pista pista) throws SQLException;

    public boolean removePista(Pista pista);

}


