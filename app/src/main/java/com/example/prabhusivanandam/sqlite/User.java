package com.example.prabhusivanandam.sqlite;

/**
 * Created by Prabhu Sivanandam on 12-Mar-17.
 */

public class User {
    String username;
    String password;

    public void setUsername(String username)
    {
        this.username=username;
    }
    public void setPassword(String password)
    {
        this.password=password;
    }
    public String getUsername()
    {
        return this.username;
    }
    public String getPassword()
    {
        return this.password;
    }
}
