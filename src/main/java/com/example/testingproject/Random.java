package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.DAO.VoliDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Wind;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.model.service.PistaService;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;


public class Random {

    public static void main(String[] args) throws SQLException {


        VoliDAO voliDAO = new VoliDAO();
        ArrayList<Integer> voli = voliDAO.getVoliIdwithPistaId(12);
        for(int i=0;i<voli.size();i++){
            System.out.print("\n "+ voli.get(i));
        }








        }

    }

