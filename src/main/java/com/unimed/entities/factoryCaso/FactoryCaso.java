package com.unimed.entities.factoryCaso;

public class FactoryCaso {

    public static interfazCaso getInstance(int Diferenciador, String nombre, String descripcion){

        interfazCaso IC = null;

        switch (Diferenciador){
            case 0:
                IC = new CasoLeve(nombre,descripcion);
            break;

            case 1:
                IC = new CasoMedio(nombre,descripcion);
            break;

            case 2:
                IC = new CasoCritico(nombre,descripcion);
            break;
        }
        return IC;
    }
}
