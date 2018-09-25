package com.vineet.orderfood.Model;

public class User {
    private String Password;
    private String Name;

    public User(String name, String password) {
        Name = name;
        Password = password;
    }

    public User(){

    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

}
