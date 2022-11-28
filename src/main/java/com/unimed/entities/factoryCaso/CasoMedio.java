package com.unimed.entities.factoryCaso;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CasoMedio implements interfazCaso{

    private String Nom; // Nombre que va a tener el caso
    private final String Desc; //Pequeña descripcion de la informacion dentro del caso
    private final LocalDateTime FechaI; // Fecha en la que se crea el caso
    private int CantiArch; // Cantidad de archivos presentes en el caso
    private boolean Activo = false; //El caso esta activo o no
    private String Path; // Path hacia donde existe el directorio

    private List<File> Docs = new ArrayList(); // Guarda un directorio de nombres para buscar un archivo

    private int difereneciador = 1;

    public CasoMedio(String Nom, String Desc){

        this.Nom = Nom;
        this.Desc = Desc;
        this.FechaI = LocalDateTime.now();
        this.CantiArch = 0;
        CrearDirectorio();
    }
    /**
     *
     * Este metodo es necesario para crear y activar el directorio dentro del Path seleccionado
     * Si el Directorio ya existe este no se crea
     */
    private void CrearDirectorio() {
        String Path = "C:\\Users" + "\\" + "santi\\IdeaProjects\\UniMed"+ "\\" + "CasoMedio" + "\\" + this.Nom;
        boolean comp = new File(Path).mkdirs();
        if(comp == true){
            this.Path = Path;
            Activo = true;
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
        this.CantiArch = n_arch;
    }




}
