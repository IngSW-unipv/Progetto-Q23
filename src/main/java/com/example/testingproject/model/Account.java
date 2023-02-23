package com.example.testingproject.model;

//singleton per istanza di account

import java.lang.constant.Constable;

public class Account {
    private String username, password, userType;


    public Account(String username, String password, String userType) {
        this.username = username;
        this.password = password;
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}



