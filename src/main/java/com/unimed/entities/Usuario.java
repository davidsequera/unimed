package com.unimed.entities;

import com.unimed.entities.Caso;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String name;
    private String EPS;
    private int Edad;
    private double Altura;
    private int Peso;
    private String RH;
    private List<Caso> Casos;

    public Usuario(String name, String eps, int e, double alt, int peso, String rh){
        this.name = name;
        this.EPS = eps;
        this.Altura = alt;
        this.Edad = e;
        this.Peso = peso;
        this.RH = rh;
        Casos = new ArrayList<Caso>();
    }
    public Usuario(String name, String eps, int e, double alt, int peso, String rh, List<Caso> C){
        this.name = name;
        this.EPS = eps;
        this.Altura = alt;
        this.Edad = e;
        this.Peso = peso;
        this.RH = rh;
        Casos = new ArrayList<Caso>(C);
    }


    public String getName() {
        return name;
    }

    public List<Caso> getCasos() {
        return Casos;
    }

    public int getPeso() {
        return Peso;
    }

    public double getAltura() {
        return Altura;
    }

    public int getEdad() {
        return Edad;
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