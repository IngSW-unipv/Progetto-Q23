package com.example.testingproject.model;
public final class UserHolder {

    private Account user;
    private static UserHolder INSTANCE ;

    private UserHolder() {

    }

    public static UserHolder getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserHolder();
        }

        return INSTANCE;
    }

    public void setUser(Account u) {
        this.user = u;
    }

    public Account getUser() {
        return this.user;
    }


}