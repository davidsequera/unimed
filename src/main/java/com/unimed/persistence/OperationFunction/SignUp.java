//package com.unimed.persistence.OperationFunction;
//
//import Entities.User;
//import Server.auth.Auth;
//import Server.database.DatabaseConnection;
//import com.unimed.persistence.auth.Auth;
//
//public class SignUp  {
//    public String act(String message) {
//        try {
//            String password = Auth.hashPassword(user.password);
//            User userDB = db.signUp(user.name, password);
//            if (userDB != null) {
//                return "";
//            } else {
//                return "";
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "";
//        }
//    }
//}
