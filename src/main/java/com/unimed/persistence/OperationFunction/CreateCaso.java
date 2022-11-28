//package com.unimed.persistence.OperationFunction;
//
//
//import com.unimed.entities.Caso;
//import com.unimed.persistence.database.*;
//
//public class CreateCaso  {
//    public String act(String request) {
//        Caso product = null;
//        try {
//            DatabaseAdapter db = mySQLConnection.getInstance();
//            product = db.CreateCaso( "", product);
//            return "";
//        }catch (Exception e){
//            e.printStackTrace();
//            if(e.getMessage().equals("No hay stock")){
//                return  "";
//            }
//            return "";
//        }
//    }
//}
