package com.example.testingproject;
import com.example.testingproject.model.Account;
import com.example.testingproject.model.DatabaseConnection;
import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.service.AccountService;
import javafx.scene.chart.PieChart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Random {

    public static void main(String[] args) throws SQLException {
        System.out.println("Testing class\n");
        DatabaseConnection connection = new DatabaseConnection();
        AccountDAO accountDAO = new AccountDAO();
        AccountService accountService = new AccountService();

        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            accounts = accountDAO.getAccounts();
            Account testingaccount = accountService.getAccountByUsername(accounts,"rick");
            System.out.print(testingaccount.getName());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        try{
           Connection conn = connection.getConnection();
            if(conn!=null) {
                System.out.print("WE DID IT!");
            }



        }
        catch(Exception e ){
            System.out.println("ERROR");
            e.printStackTrace();
        }
        }

    }

