package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.DAO.PistaDAO;
import com.example.testingproject.model.Pista;
import com.example.testingproject.model.Wind;
import com.example.testingproject.model.service.AccountService;
import com.example.testingproject.model.service.PistaService;


import java.sql.SQLException;
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) throws SQLException {


        PistaDAO pistaDAO = new PistaDAO();
        Pista pista = new Pista(9,2300,"Y");
        pistaDAO.removePista(pista);









        }

    }

