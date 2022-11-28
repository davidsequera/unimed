package com.unimed.entities;

public class Credenciales {
    private String id;
    private String user_id;
    private String username;
    private String password;

    public Credenciales(String username, String password) {
        this.user_id = null;
        this.username = username;
        this.password = password;
    }
    public Credenciales(String user_id, String username, String password) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
    }
    public String setUser_id() {
        return user_id;
    }
    public String getUser_id() {
        return user_id;
    }
    public String getUser() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
