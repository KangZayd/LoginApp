package com.ahmadrosid.loginapp.model;

/**
 * Created by ocittwo on 27/09/16.
 *
 * @Web https://ahmadrosid.com/
 * @Email ocittwo@gmail.com
 * @Github https:/github.com/ar-android
 * @Developer Ahmad Rosid
 *
 * © 2016 | LoginApp All Rights Reserved
 */
public class User {

    public String email;
    public String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override public String toString() {
        return "User email = " + email +
                " and user password = " + password;
    }
}
