package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) throws SQLException {
        System.out.println("Testing class\n");

        AccountDAO accountDAO = new AccountDAO();




            System.out.print("\nTesting inputting data as well\n");
            //Account newaccount = new Account("newricky","password1","2","newRiccardo","newsurname");

            //accounts = accountService.addAccount(newaccount);
          Account account = accountDAO.getAccountbyUsername("daniele");

        ArrayList<Account> accounts = new ArrayList<Account>();
        accounts = accountDAO.getAccounts();

        for(int i =0;i<accounts.size();i++){
            System.out.print(accounts.get(i).getUsername() + "  " + accounts.get(i).getUserType());
            System.out.print("\n");
        }
          System.out.print(account.getUserType());









        }

    }

