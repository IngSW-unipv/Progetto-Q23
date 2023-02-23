package com.example.testingproject.model.service;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;

import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;


public class AccountService {

    AccountDAO accountDAO = new AccountDAO();

    public Account getAccountByUsername(ArrayList<Account> accounts, String inputUsername) throws SQLException {
        try{
        int breakPoint = 0;
        accounts = accountDAO.getAccounts();
        for(int i =0;i<accounts.size();i++){
            if(accounts.get(i).getUsername().equals(inputUsername)){
                breakPoint =i;
                break;
            }

        }


        return accounts.get(breakPoint);
    } catch (SQLException e){
            e.printStackTrace();
            System.out.print("Database Error when finding Account by Username!");
            return null;
        }
            
        }


   public void changeUsername(Account account, String newUsername){
        account.setUsername(newUsername);

   }

    public void changePassword(Account account, String newPassword){
     account.setPassword(newPassword);
    }



}
