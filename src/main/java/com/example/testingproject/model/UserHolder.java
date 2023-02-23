package com.example.testingproject.model;
public final class UserHolder {

    private Account user;
    private final static UserHolder INSTANCE = new UserHolder();

    private UserHolder() {}

    public static UserHolder getInstance() {
        return INSTANCE;
    }

    public void setUser(Account u) {
        this.user = u;
    }

    public Account getUser() {
        return this.user;
    }
}