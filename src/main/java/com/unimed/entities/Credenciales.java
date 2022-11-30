package com.unimed.entities;

public class Credenciales {
    private String id;
    private String username;
    private String password;
    private String user_id;

    public Credenciales(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Credenciales(String id, String username, String password,  String user_id) {
        this.id = id;
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
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
}
