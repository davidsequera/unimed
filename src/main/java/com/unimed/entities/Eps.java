package com.unimed.entities;

public class Eps {
    public String id;
    public String nombre;

    public Eps(String nombre){
        this.nombre = nombre;
    }
    // Database constructor
    public Eps(String id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }
}
