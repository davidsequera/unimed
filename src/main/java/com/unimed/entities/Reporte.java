package com.unimed.entities;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVWriter;


public class Reporte {
    private Usuario usuario;

    public Reporte(Usuario usuario) {
        this.usuario = usuario;
    }
    public void generarReporte() {
        //TODO: Implementar
    }
    public void writeCSV(String[] header,String [][] data, String filePath){
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
