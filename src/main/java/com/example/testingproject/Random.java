package com.example.testingproject;
import com.example.testingproject.model.Account;

import com.example.testingproject.model.DAO.AccountDAO;
import com.example.testingproject.model.service.AccountService;


import java.sql.SQLException;
import java.util.ArrayList;


public class Random {

    public static void main(String[] args) throws SQLException {
        System.out.println("Testing class\n");

        AccountDAO accountDAO = new AccountDAO();
        AccountService accountService = new AccountService();
        Account tempaccount = accountService.findAccountByUsername("ri");
        System.out.print(tempaccount.getUserType());


      //  accountService.changeUsername(tempaccount,"chad");
        //Account newtempaccount = accountService.findAccountByUsername("chad");
        //System.out.print(newtempaccount.getPassword());












        }

    }

