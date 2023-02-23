package com.example.testingproject.model.service;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;


import java.sql.SQLException;
import java.util.ArrayList;


public class AccountService {

    AccountDAO accountDAO = new AccountDAO();




   public void changeUsername(Account account, String newUsername){
        account.setUsername(newUsername);

   }

    public void changePassword(Account account, String newPassword){
     account.setPassword(newPassword);
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



}
