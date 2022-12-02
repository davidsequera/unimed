package com.unimed.persistence.OperationFunction;


import com.unimed.entities.Caso;
import com.unimed.persistence.database.*;

public class CrearCaso {
    public Caso act(Caso caso) throws Exception {
        Caso caso_db;
        DatabaseAdapter db = mySQLConnection.getInstance();
        caso_db = db.crearCaso(caso);
        return caso_db;
    }
}
