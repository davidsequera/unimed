package com.unimed.persistence.OperationFunction;

import com.unimed.entities.Credenciales;
import com.unimed.entities.Usuario;
import com.unimed.persistence.auth.Auth;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;
import javafx.util.Pair;

public class SignUp {
    public Pair<Credenciales, Usuario> act(Credenciales credenciales, Usuario usuario){
        try {
            // Hash password
            credenciales.setHash(Auth.hashPassword(credenciales.getPassword()));
            // Crear usuario
            DatabaseAdapter db = mySQLConnection.getInstance();
            Pair<Credenciales, Usuario> usuario_info =db.crearUsuario(credenciales, usuario);
            if(!credenciales.getUsername().equals(usuario_info.getKey().getUsername())){
                System.out.println(usuario_info.getKey());
                System.out.println(credenciales);
                throw new Exception("Credenciales no coinciden");
            }
            if(!usuario.nombre.equals(usuario_info.getValue().nombre)){
                throw new Exception("Usuario no coincide");
            }
            return usuario_info;
        } catch (Exception e) {
            e.printStackTrace();
            return new Pair<>(null, null);
        }
    }
}
