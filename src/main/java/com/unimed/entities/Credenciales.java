package com.unimed.entities;

public class Credenciales {
    private String id;
    private String username;
    private String password;
    private String user_id;
    private Boolean hash_password;

    public Credenciales(String username, String password) {
        this.username = username;
        this.password = password;
        this.hash_password = false;
    }
    public Credenciales(String id, String username, String password,  String user_id) {
        this.id = id;
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.hash_password = false;
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

    public void setHash(String hash) {
        this.password = hash;
        this.hash_password = true;
    }

    @Override
    public String toString() {
        return "Credenciales{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", user_id='" + user_id + '\'' +
                '}';
    }
}
