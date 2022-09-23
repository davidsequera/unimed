package com.unimed;

import java.util.ArrayList;
import java.util.List;

public class Dat_Usuario {

    private String Name;
    private String EPS;
    private int Edad;
    private double Altura;
    private int Peso;
    private List<Caso> Casos;

    public Dat_Usuario(String Name, String eps, int e, double alt, int peso){
        this.Name = Name;
        this.EPS = eps;
        this.Altura = alt;
        this.Edad = e;
        this.Peso = peso;
        Casos = new ArrayList<Caso>();
    }
    public Dat_Usuario(String Name, String eps, int e, double alt, int peso, List<Caso> C){
        this.Name = Name;
        this.EPS = eps;
        this.Altura = alt;
        this.Edad = e;
        this.Peso = peso;
        Casos = new ArrayList<Caso>(C);
    }


    public String getName() {
        return Name;
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
}
