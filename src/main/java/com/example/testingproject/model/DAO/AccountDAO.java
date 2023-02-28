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

            String query = "SELECT username,password,nome,cognome, tipo FROM AirportManager.users;";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            String tempUsername,tempPassword,tempType,tempName,tempSurname;

            while(resultSet.next()){
                tempUsername = resultSet.getString(1);
                tempPassword = resultSet.getString(2);
                tempType = resultSet.getString(5);
                tempName = resultSet.getString(3);
                tempSurname = resultSet.getString(4);
                Account tempAccount = new Account(tempUsername,tempPassword,tempType,tempName,tempSurname);
                accounts.add(tempAccount);
            }

        }

        catch (SQLException e) {
            connection.closeConnection(conn);
            throw new RuntimeException(e);
        }

connection.closeConnection(conn);
        return accounts;
    }

    public boolean createAccount(Account account) throws SQLException {

        Connection conn = connection.getConnection();
        try{
            String query = "INSERT INTO AirportManager.users (username,password,nome,cognome,tipo)  Values " +
                    "('"+account.getUsername()+ "','" +account.getPassword()+"','"+account.getName()+"','"+account.getSurname()+"', '" +account.getUserType()+"');";
            PreparedStatement preparedStatement =conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            connection.closeConnection(conn);
            return false;
        }

    }

    public Account getAccountbyUsername(String username) throws SQLException {

        Connection conn = connection.getConnection();
        try {
            String tempUsername,tempPassword,tempType,tempName,tempSurname;
            String query = "SELECT username,password,nome,cognome, tipo FROM AirportManager.users WHERE username = '"+username+"';";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(!resultSet.isBeforeFirst()){
                return null;
            }else {
                resultSet.next();

                tempUsername = resultSet.getString(1);
                tempPassword = resultSet.getString(2);
                tempType = resultSet.getString(5);
                tempName = resultSet.getString(3);
                tempSurname = resultSet.getString(4);
                Account tempAccount = new Account(tempUsername, tempPassword, tempType, tempName, tempSurname);
                connection.closeConnection(conn);
                return tempAccount;

            }

        }catch (SQLException e){
            e.printStackTrace();
            connection.closeConnection(conn);
            return null;
        }
    }

public boolean updateUsername(String currentUsername, String updateUsername) throws SQLException {

    Connection conn = connection.getConnection();


        try{
            String query = "UPDATE AirportManager.users SET username = '" +updateUsername+"' WHERE (username = '"+ currentUsername+ "');";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        }catch(Exception exception){
            exception.printStackTrace();
            connection.closeConnection(conn);
            return false;

        }


}

    public boolean updatePassword(String currentUsername, String updatePassword) throws SQLException {

        Connection conn = connection.getConnection();
        try{
            String query = "UPDATE AirportManager.users SET password = '" +updatePassword+"' WHERE (username = '"+currentUsername+"');";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        }catch(Exception exception){
            exception.printStackTrace();
            connection.closeConnection(conn);
            return false;

        }


    }

    public boolean updateType(String currentUsername, String updateType) throws SQLException {

        Connection conn = connection.getConnection();
        try{
            String query = "UPDATE AirportManager.users SET tipo = '"+updateType+"' WHERE (username = '"+currentUsername+"');";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        }catch(Exception exception){
            exception.printStackTrace();
            connection.closeConnection(conn);
            return false;

        }


    }

    public boolean deleteAccount(Account account){
        Connection conn = connection.getConnection();

        try {
            String query = "DELETE FROM AirportManager.users WHERE username ='"+account.getUsername()+"';";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.executeUpdate();
            connection.closeConnection(conn);
            return true;

        }
        catch (SQLException e) {
           e.printStackTrace();
           return false;
        }

    }


}
