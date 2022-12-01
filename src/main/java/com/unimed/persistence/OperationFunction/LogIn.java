package com.unimed.persistence.OperationFunction;

import com.unimed.entities.Credenciales;
import com.unimed.persistence.auth.Auth;
import com.unimed.persistence.database.*;

import com.unimed.entities.Usuario;
import javafx.util.Pair;

public class LogIn  {
    public Pair<Credenciales, Usuario> act(Credenciales credenciales){
        try {
            DatabaseAdapter db = mySQLConnection.getInstance();

            // Consultar credenciales y usuario
            Credenciales credenciales_db = db.getCredencialesByUsername(credenciales.getUsername());
            // Verificar credenciales
            boolean authorized = Auth.verifyPassword(credenciales.getPassword(), credenciales_db.getPassword());
            if(!authorized){
                throw new Exception("Credenciales no coinciden");
            }
            Usuario usuario_db = db.consultarUsuario(credenciales_db.getUser_id());
            return new Pair<>(credenciales_db, usuario_db);
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>(null, null);
        }
    }
}
