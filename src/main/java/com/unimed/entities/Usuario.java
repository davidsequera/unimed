package com.unimed.entities;

import com.unimed.entities.Caso;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String id;
    private String nombre;
    private String EPS;
    private int edad;
    private double altura;
    private int peso;
    private String RH;
    private List<Caso> Casos;

    public Usuario(String nombre, String eps, int edad, double altura, int peso, String rh){
        this.id = null;
        this.nombre = nombre;
        this.EPS = eps;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.RH = rh;
        Casos = new ArrayList<Caso>();
    }
    public Usuario(String nombre, String eps, int edad, double altura, int peso, String rh, List<Caso> C){
        this.id = null;
        this.nombre = nombre;
        this.EPS = eps;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.RH = rh;
        Casos = new ArrayList<Caso>(C);
    }

    public String setId(String id) {
        return this.id = id;
    }
    public String getId() {
        return id;
    }



    public String getNombre() {
        return nombre;
    }

    public List<Caso> getCasos() {
        return Casos;
    }

    public int getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    public int getEdad() {
        return edad;
    }

    public String getEPS() {
        return EPS;
    }

    public String getRH() {
        return RH;
    }
    public void AddCase(Caso C){
        Casos.add(C);
    }
}