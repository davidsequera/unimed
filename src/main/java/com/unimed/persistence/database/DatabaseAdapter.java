package com.unimed.persistence.database;

import com.unimed.entities.*;
import javafx.util.Pair;

import java.util.List;

public interface DatabaseAdapter {
    // Coneccion a la base de datos
    void connect() throws Exception;
    void disconnect();
    void getProperties() ;

    // Peticiones
    List<Caso> consultarCasos(String user_id) throws Exception;
    Caso crearCaso(Caso c) throws Exception;

    Usuario consultarUsuario(String user_id) throws Exception;
    Credenciales getCredenciales(String username)  throws Exception;
    Credenciales getCredencialesByUsername(String username) throws Exception;
    Pair<Credenciales, Usuario> crearUsuario(Credenciales credenciales, Usuario usuario)  throws Exception;
}
