package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Wind;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.model.service.PistaService;


import java.sql.SQLException;
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) throws SQLException {
        Wind wind = new Wind();
        System.out.println("Testing class\n");
for(int i =0;i<10;i++){
    System.out.print("\n"+  wind.getDirection());
}











        }

    }

