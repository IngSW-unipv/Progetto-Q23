package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Voli;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IVoliDAO {


    public ArrayList<Integer> getVoliIdwithPistaId(Integer pistaId) throws SQLException;

    public Voli findVoloByID(Integer ID);

}
