package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;


import java.sql.Connection;
import java.sql.SQLException;


public class Random {

    public static void main(String[] args) throws SQLException {
        System.out.println("Testing class\n");

        AccountDAO accountDAO = new AccountDAO();




            System.out.print("\nTesting inputting data as well");
            //Account newaccount = new Account("newricky","password1","2","newRiccardo","newsurname");

            //accounts = accountService.addAccount(newaccount);
          Account account = accountDAO.getAccountbyUsername("daniele");
          System.out.print(account.getPassword());









        }

    }

