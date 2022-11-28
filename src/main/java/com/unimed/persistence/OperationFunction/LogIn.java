//package com.unimed.persistence.OperationFunction;
//
//import com.unimed.persistence.auth.Auth;
//import com.unimed.persistence.database.*;
//
//import com.unimed.entities.Usuario;
//
//public class LogIn  {
//    public Usuario act(Usuario user, String password) {
//        try {
//            DatabaseAdapter db = mySQLConnection.getInstance();
//            Usuario userDB = db.logIn(user.name);
//            boolean authorized = Auth.verifyPassword(user.password, userDB.password);
//            if(!authorized) {
//                return "";
//            }
//            return "";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}
