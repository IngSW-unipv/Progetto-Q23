package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Luggage;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBagagliDAO {

    public  ArrayList<Luggage> getLuggage() throws SQLException;
    public Luggage getLuggaggeById(int id) throws SQLException;
    public void modifyStato(int id, String Stato) throws SQLException;

    public boolean verify(int idBagaglio)throws SQLException;
    public boolean verifyFlyPartenza(int idVolo, String Airport) throws SQLException;
    public boolean verifyFlyArrivo(int idVolo, String Airport) throws SQLException;

    public void addLuggage(int peso, String stato, int volo) throws SQLException;

    public boolean verifyPlaceonBord(int idVolo, int wight) throws SQLException;

    public int sumWigth(int idVolo) throws SQLException;


}
