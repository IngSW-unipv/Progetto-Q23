package com.example.testingproject.model.service;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;


import java.sql.SQLException;
import java.util.ArrayList;


public class AccountService {

    AccountDAO accountDAO = new AccountDAO();




   public void changeUsername(Account account, String newUsername) throws SQLException {

       try {
           accountDAO.updateUsername(account.getUsername(),newUsername);
           account.setUsername(newUsername);
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }


   }



    public void changePassword(Account account, String newPassword){
     account.setPassword(newPassword);
    }



    public void changeUserType(Account account, String newType){

    }






    public boolean AddAccount(Account account) throws SQLException {
        try {
            accountDAO.createAccount(account);
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }

    public Account findAccountByUsername(String username) throws SQLException {

        try {
            return accountDAO.getAccountbyUsername(username);
        } catch (SQLException e) {
            return null;


        }


    }



}
