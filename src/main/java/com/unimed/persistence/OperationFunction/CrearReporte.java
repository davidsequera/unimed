package com.unimed.persistence.OperationFunction;

import com.opencsv.CSVWriter;
import com.unimed.entities.Caso;
import com.unimed.entities.Eps;
import com.unimed.persistence.database.DatabaseAdapter;
import com.unimed.persistence.database.mySQLConnection;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CrearReporte {

    private final String PATH = "src/main/resources/reportes";
    public List<Caso> act(String user_id) throws Exception {
        ConsultarCasos consultarCasos = new ConsultarCasos();
        List<Caso> casos_db = consultarCasos.act(user_id);
        writeCSV(getHeader(casos_db.get(0)), getData(casos_db), PATH +'/'+user_id+".csv");
        return casos_db;
    }
    private String[] getHeader(Caso c) {
        ArrayList<String> header = new ArrayList<>();
        for (Field f : c.getClass().getDeclaredFields()) {
            if(!(f.getName().equals("PATH") || f.getName().equals("docs"))){
                header.add(f.getName());
            }
        }
        return header.stream().toArray(String[]::new);
    }

    private String[][] getData(List<Caso> casos){
        String[][] data = new String[casos.size()][];
        for(Caso c : casos){
            String [] row = {c.getId(), c.getNombre(), c.getDescripcion(), String.valueOf(c.getFecha_creacion()), c.getFecha_creacion_date(), String.valueOf(c.getEstado()), String.valueOf(c.getN_archivos()), c.getUser_id(), c.getEps_id(), c.getPath()};
            data[casos.indexOf(c)] = row;
        }
        return data;
    }

    private void writeCSV(String[] header, String[][] data, String filePath){
        java.io.File file = new java.io.File(filePath);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile,',', CSVWriter.NO_QUOTE_CHARACTER, CSVWriter.DEFAULT_ESCAPE_CHARACTER, CSVWriter.DEFAULT_LINE_END);

            // add data to csv
            writer.writeNext(header);
            for (String[] row : data) {
                writer.writeNext(row);
            }

            // closing writer connection
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
