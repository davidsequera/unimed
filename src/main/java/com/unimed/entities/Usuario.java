package com.unimed.entities;

import com.unimed.entities.Caso;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    public String id;
    public String nombre;
    public int edad;
    public double altura;
    public double peso;
    public String RH;
    public String eps_id;
    public List<Caso> casos;

    public Usuario(String nombre, int edad, double altura, double peso, String RH, String eps_id){
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
        this.peso = peso;
        this.RH = RH;
        this.eps_id = eps_id;
        this.casos = new ArrayList<>();
    }
    // Database constructor
    public Usuario(String id, String nombre, String edad, String altura,String peso, String RH, String eps_id){
        this.id = id;
        this.nombre = nombre;
        this.edad = Integer.parseInt(edad);
        this.altura = Double.parseDouble(altura);
        this.peso = Double.parseDouble(peso);
        this.RH = RH;
        this.eps_id = eps_id;
        this.casos = new ArrayList<>();
    }
    public void setCasos(List<Caso> casos) {
        this.casos = casos;
    }
    public void addCaso(Caso C){
        casos.add(C);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                ", peso=" + peso +
                ", RH='" + RH + '\'' +
                ", eps_id='" + eps_id + '\'' +
                ", casos=" + casos +
                '}';
    }
}