package com.unimed.entities;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Caso {
    private String id;
    private String nombre; // Nombre que va a tener el caso
    private final String descripcion; //Pequeña descripcion de la informacion dentro del caso
    private final LocalDateTime fecha_creacion; // Fecha en la que se crea el caso
    private int n_archivos; // Cantidad de archivos presentes en el caso
    private EstadoCaso estado; //El caso esta activo o no
    private String Path; // Path hacia donde existe el directorio

    private List<File> Docs = new ArrayList(); // Guarda un directorio de nombres para buscar un archivo

    public Caso(String nombre, String descripcion){

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = LocalDateTime.now();
        this.estado = EstadoCaso.CERRADO;
        this.n_archivos = 0;
        CrearDirectorio();
    }
    public Caso(String nombre, String descripcion, String fecha_creacion, String n_archivos, String estado, String path) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        // TODO Cast de fecha
        this.fecha_creacion = LocalDateTime.now();
        // String to int
        this.n_archivos = Integer.parseInt(n_archivos);
        this.estado = EstadoCaso.CERRADO;
    }

    /**
     *
     * Este metodo es necesario para crear y activar el directorio dentro del Path seleccionado
     * Si el Directorio ya existe este no se crea
     */
    private void CrearDirectorio() {
        String Path = "C:\\Users" + "\\" + "santi\\IdeaProjects\\UniMed"+ "\\" + this.nombre;
        boolean comp = new File(Path).mkdirs();
        if(comp == true){
            this.Path = Path;
            estado = EstadoCaso.ABIERTO;
        }
    }
    /**
     *
     * @param arch , Lista de tipo archivo
     * Este metodo contiene una rutina para guardar un archivo dado en el directorio del caso
     */
    public void GuardarArchivos(List<File>arch){
        if(arch.size() != 0)
        {
            for(int i = 0;i < arch.size();i++)
            {
                String name_arch = arch.get(i).getName();
                arch.get(i).renameTo(new File(this.Path + "\\" + name_arch));
                this.Docs.add(arch.get(i));
            }
        }
        ActualizarExistencia();
    }
    private void ActualizarExistencia(){
        int n_arch = Docs.size();
        this.n_archivos = n_arch;
    }

}




