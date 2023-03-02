package com.example.testingproject.model.DAO;

import com.example.testingproject.model.Account;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IAccountDAO {

    public ArrayList<Account> getAccounts() throws SQLException;

    public boolean createAccount(Account account) throws SQLException;

    public Account getAccountbyUsername(String username) throws SQLException;

    public boolean updateUsername(String currentUsername, String updateUsername) throws SQLException;

    public boolean updatePassword(String currentUsername, String updatePassword) throws SQLException;

    public boolean updateType(String currentUsername, String updateType) throws SQLException;

    public boolean deleteAccount(Account account);



}
