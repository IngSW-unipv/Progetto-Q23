package com.example.testingproject.model;

public class Account {
    private String username, password, userType,name,surname;
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

    public void setLoggedIn(boolean bool){
       this.isLoggedIn = bool;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setSurname(String newSurname){
        this.surname = newSurname;
    }





    //istanza singleton di current account, lazy implementation, istanza nuova con valori null
    private static Account currentAccount;

    public static Account getCurrentAccount() {
        if (currentAccount == null) {
currentAccount = new Account(null, null,null,null, null);

        }
return currentAccount;
    }


    public void logOut(Account account){
        account.setPassword(null);
        account.setUsername(null);
        account.setUserType(null);
        account.setLoggedIn(false);

    }

    public void logIn(Account account,String username, String password, String userType){
        account.setUsername(username);
        account.setPassword(password);
        account.setUserType(userType);
        account.setLoggedIn(true);


    }


    public boolean checkPassword(Account account, String InputPassword){
        if(account.password.equals(InputPassword)){
            return true;
        }else{
            return false;
        }
    }



}



