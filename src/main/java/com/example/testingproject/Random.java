package com.example.testingproject;

import com.example.testingproject.model.DAO.VoliDAO;


import java.sql.SQLException;
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) throws SQLException {


        VoliDAO voliDAO = new VoliDAO();
        ArrayList<Integer> voli = voliDAO.getVoliIdwithPistaId(12);
        for(int i=0;i<voli.size();i++){
            System.out.print("\n "+ voli.get(i));
        }








        }

    }

