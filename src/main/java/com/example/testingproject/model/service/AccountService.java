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



    public void changePassword(Account account, String newPassword) throws SQLException {
        try {
            accountDAO.updatePassword(account.getUsername(),newPassword);
            account.setPassword(newPassword);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }



    public void changeUserType(Account account, String newType){
        try {
            accountDAO.updateType(account.getUsername(),newType);
            account.setUserType(newType);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }






    public boolean AddAccount(Account account) throws SQLException {
       boolean output;
        try {
            output = accountDAO.createAccount(account);

        }
        catch(SQLException e){
            e.printStackTrace();
            output = false;
        }
return output;
    }

    public Account findAccountByUsername(String username) throws SQLException {

        try {
            return accountDAO.getAccountbyUsername(username);
        } catch (SQLException e) {
            return null;


        }


    }

    public boolean deleteAccount(Account account){
     boolean outcome = accountDAO.deleteAccount(account);
       return outcome;


    }

    public boolean checkPassword(Account account, String InputPassword){
        return account != null && account.getPassword().equals(InputPassword);
    }

}
