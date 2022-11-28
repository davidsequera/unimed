//package com.unimed.persistence.OperationFunction;
//
//import com.unimed.entities.Caso;
//import com.unimed.persistence.database.DatabaseAdapter;
//import com.unimed.persistence.database.mySQLConnection;
//
//import java.util.ArrayList;
//
//public class Consult {
//    public String act(String request) {
//        ArrayList<Caso> casos;
//        try {
//            DatabaseAdapter db = mySQLConnection.getInstance();
//            casos = (ArrayList<Caso>) db.cosultCasos(request);
//            return  "";
//        }catch (Exception e){
//            e.printStackTrace();
//            return  "";
//        }
//    }
//}
