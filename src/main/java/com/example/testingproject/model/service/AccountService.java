package com.example.testingproject.model.service;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DAO.AccountDAO;


import java.sql.SQLException;
import java.util.ArrayList;


public class AccountService {

    AccountDAO accountDAO = new AccountDAO();

    public Account getAccountByUsername(ArrayList<Account> accounts, String inputUsername) throws SQLException {
        try{
        Integer breakPoint = null;
        accounts = accountDAO.getAccounts();
        for(int i =0;i<accounts.size();i++){
            if(accounts.get(i).getUsername().equals(inputUsername)){
                breakPoint =i;
                break;
            }

        }

if(breakPoint != null) {
    return accounts.get(breakPoint);
}else{
    System.out.print("\nNo Such Account!");
    return null;
}
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
