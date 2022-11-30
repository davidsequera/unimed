package com.unimed.entities;

public enum EstadoCaso {
    INICIADO("INICIADO"), ABIERTO("ABIERTO"),CERRADO("CERRADO"), CANCELADO("CANCELADO");
    final String estado;
    EstadoCaso(String estado) {
        this.estado = estado;
    }
}
