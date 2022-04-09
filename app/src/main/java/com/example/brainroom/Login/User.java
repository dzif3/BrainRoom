package com.example.brainroom.Login;

public class User {
    public String firstName;
    public String Email;
    public String Password;


    public User (String firstName) {
        this.firstName = firstName;

    }

    public User(String email, String password) {
        this.Email = email;
        this.Password = password;
    }
}
