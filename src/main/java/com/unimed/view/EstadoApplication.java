package com.unimed.view;

import com.unimed.entities.Usuario;

public class EstadoApplication {
    private static EstadoApplication estado;
    private Usuario usuario;
    private EstadoApplication(){

    }
    public static EstadoApplication getInstance(){
        if(estado == null){
            estado = new EstadoApplication();
        }
        return estado;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Usuario getUsuario() {
        return usuario;
    }
}
