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

        AccountDAO accountDAO = new AccountDAO();
        AccountService accountService = new AccountService();

        ArrayList<Account> accounts = new ArrayList<Account>();
        try {
            System.out.print("\nTesting inputting data as well");
            Account newaccount = new Account("newricky","password1","2","newRiccardo","newsurname");

            accounts = accountService.addAccount(newaccount);






        } catch (SQLException e) {
            e.printStackTrace();

        }



        }

    }

