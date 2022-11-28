package com.unimed.entities;

public class Credenciales {
    private String user_id;
    private String username;
    private String password;

    public Credenciales(String user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }
    public String getUserId() {
        return user_id;
    }
    public String getUser() {
        return username;
    }

    public String getId() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
