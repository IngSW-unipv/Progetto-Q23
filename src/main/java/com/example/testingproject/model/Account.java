package com.example.testingproject.model;

public class Account {
    private String username, password, userType;
    private boolean isLoggedIn;

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
    public boolean getLoggedIn(){
        return this.isLoggedIn;
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





    //istanza singleton di current account, lazy implementation, istanza nuova con valori null
    private static Account currentAccount;

    public static Account getCurrentAccount() {
        if (currentAccount == null) {
currentAccount = new Account(null, null,null);

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



