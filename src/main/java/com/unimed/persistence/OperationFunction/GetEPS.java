package com.unimed.persistence.OperationFunction;

import com.unimed.entities.Eps;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;

import java.util.List;

public class GetEPS {
    public List<Eps> act(){
        try {
            DatabaseAdapter db = mySQLConnection.getInstance();
            List<Eps> eps_db = db.getEPS();
            return eps_db;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
