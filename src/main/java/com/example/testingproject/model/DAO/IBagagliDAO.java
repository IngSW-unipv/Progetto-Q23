package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Luggage;
import com.example.testingproject.model.VistaVoloBagaglio;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IBagagliDAO {

    public Luggage getLuggaggeById(int id) throws SQLException;
    public void modifyStato(int id, String Stato) throws SQLException;

    public boolean verifyFly(int idVolo, String firstAirport, String secondAirport) throws SQLException;

    public void addLuggage(int peso, String stato, int volo) throws SQLException;

    public boolean verifyPlaceonBord(int idVolo, int wight, String firstAirport, String secondAirport) throws SQLException;

    public int sumWigth(int idVolo) throws SQLException;

    public boolean verifyLuggegeinFly(int idBagaglio, int idVolo) throws SQLException;

    public ArrayList<VistaVoloBagaglio> getVistaArrivo() throws SQLException;

    public boolean removeLuggage(int idBagaglio) throws SQLException;




}
