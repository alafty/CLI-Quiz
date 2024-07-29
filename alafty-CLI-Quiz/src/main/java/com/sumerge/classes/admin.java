package com.sumerge.classes;

public class Admin extends User {

    public Admin(String username) {
        setUsername(username);
        setAdmin(true);
    }


}
