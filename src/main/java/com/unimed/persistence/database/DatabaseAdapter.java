package com.unimed.persistence.database;

import com.unimed.entities.*;

import java.util.List;

public interface DatabaseAdapter {
    // Coneccion a la base de datos
    void connect() throws Exception;
    void disconnect();
    void getProperties() throws Exception;

    // Peticiones
    List<Caso> cosultarCasos(String user_id) throws Exception;
    Caso crearCaso(String user_id, Caso c) throws Exception;

    Usuario consultarUsuario(String user_id) throws Exception;
    Credenciales logIn(String username)  throws Exception;
    Credenciales signUp(Credenciales credenciales, Usuario usuario)  throws Exception;
}
