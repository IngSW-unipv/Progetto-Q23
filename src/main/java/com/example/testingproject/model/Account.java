package com.example.testingproject.model;


public class Account {
    private String username;
    private String password;
    private String userType;
    private final String name;
    private final String surname;
    private boolean isLoggedIn;

    public Account(String username, String password, String userType, String name, String surname) {
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.name = name;
        this.surname = surname;
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
    public boolean getLoggedIn(){
        return this.isLoggedIn;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public void setUsername(String newUsername){
        this.username = newUsername;


    }

    public void setPassword(String newPassword){
        this.password = newPassword;

    }

    public void setUserType(String newUserType){
        this.userType = newUserType;

    }

    public boolean checkPassword( String InputPassword){
        return this!= null && this.getPassword().equals(InputPassword);
    }




}



