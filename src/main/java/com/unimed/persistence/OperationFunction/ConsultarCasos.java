package com.unimed.persistence.OperationFunction;

import com.unimed.entities.Caso;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;

import java.util.List;

public class ConsultarCasos {
    public List<Caso> act(String user_id) throws Exception {
        List<Caso> casos;
        DatabaseAdapter db = mySQLConnection.getInstance();
        casos = db.consultarCasos(user_id);
        return  casos;
    }
}
