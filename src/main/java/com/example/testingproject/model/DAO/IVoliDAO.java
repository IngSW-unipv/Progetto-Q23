package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Voli;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IVoliDAO {
    public  ArrayList<Voli> getVoliPartenza() throws SQLException;
    public  ArrayList<Voli> getVoliArrivo() throws SQLException;
    public  boolean inserisciVoli( int idVolo, int durataapp, int ritardoapp,int aereo,String gate) throws SQLException;

    public  boolean inserisciPartenza(  int idVolo,int pista,String dataora,String aeroportop) throws SQLException;
    public  boolean inserisciArrivo( int idVolo, int pista,String dataora,String aeroportop) throws SQLException;
    public ArrayList<Integer> getVoliIdwithPistaId(Integer pistaId) throws SQLException;
    public Voli findVoloByID(Integer ID);



}
