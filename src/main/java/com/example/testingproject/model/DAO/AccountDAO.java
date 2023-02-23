package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Account;
import com.example.testingproject.model.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {
    DatabaseConnection connection = new DatabaseConnection();


    public ArrayList<Account> getAccounts() throws SQLException {
        ArrayList<Account> accounts = new ArrayList<>();
        Connection conn = connection.getConnection();
        try{
            //change tipo to type, change database table layout
            String query = "SELECT username, password, tipo FROM Utente";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            String tempUsername,tempPassword,tempType;

            while(resultSet.next()){
                tempUsername = resultSet.getString(1);
                tempPassword = resultSet.getString(2);
                tempType = resultSet.getString(3);
                Account tempAccount = new Account(tempUsername,tempPassword,tempType);
                accounts.add(tempAccount);
            }

        }

        catch (SQLException e) {
            throw new RuntimeException(e);
        }

connection.closeConnection(conn);
        return accounts;
    }

    public boolean createAccount(Account account){
        Connection conn = connection.getConnection();
        try{
            String query = "INSERT INTO Utente (" + account.getUsername() + "," + account.getPassword() + "," + account.getUserType() + ")";
            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.executeQuery();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }




}