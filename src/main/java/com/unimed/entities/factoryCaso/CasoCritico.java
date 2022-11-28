package com.unimed.entities.factoryCaso;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CasoCritico implements interfazCaso {

    private String nombre; // Nombre que va a tener el caso
    private final String descripcion; //Pequeña descripcion de la informacion dentro del caso
    private final LocalDateTime fechaInicial; // Fecha en la que se crea el caso
    private int cantidad_archivos; // Cantidad de archivos presentes en el caso
    private boolean estado = false; //El caso esta activo o no
    private String Path; // Path hacia donde existe el directorio

    private List<File> Docs = new ArrayList(); // Guarda un directorio de nombres para buscar un archivo

    private int difereneciador = 2;

    public CasoCritico(String nombre, String descripcion){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicial = LocalDateTime.now();
        this.cantidad_archivos = 0;
        CrearDirectorio();
    }
    /**
     *
     * Este metodo es necesario para crear y activar el directorio dentro del Path seleccionado
     * Si el Directorio ya existe este no se crea
     */
    private void CrearDirectorio() {
        String Path = "C:\\Users" + "\\" + "santi\\IdeaProjects\\UniMed"+ "\\" + "CasoCritico" + "\\" + this.nombre;
        boolean comp = new File(Path).mkdirs();
        if(comp == true){
            this.Path = Path;
            estado = true;
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
    public void ActualizarExistencia(){
        int n_arch = Docs.size();
        this.cantidad_archivos = n_arch;
    }




}