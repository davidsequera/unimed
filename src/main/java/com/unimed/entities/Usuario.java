package com.unimed.entities;

import com.unimed.entities.Caso;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String id;
    public String nombre;
    public String EPS;
    public int edad;
    public double altura;
    public int peso;
    public String RH;
    public List<Caso> Casos;

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
    
    public void AddCase(Caso C){
        Casos.add(C);
    }
}