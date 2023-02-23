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

    public ArrayList<Account> addAccount(Account account) throws SQLException {
        try {
            accountDAO.createAccount(account);
            return accountDAO.getAccounts();
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }

    }



}
