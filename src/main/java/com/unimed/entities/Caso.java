package com.unimed.entities;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Caso {

    public String id;
    public String nombre; // Nombre que va a tener el caso
    public final String descripcion; //Pequeña descripcion de la informacion dentro del caso
    public final long fecha_creacion; // Fecha en la que se crea el caso
    public EstadoCaso estado; //El caso esta activo o no
    public int n_archivos; // Cantidad de archivos presentes en el caso
    public String user_id;
    public String eps_id;
    public String path; // Path hacia donde existe el directorio
    public List<File> docs = new ArrayList<>(); // Guarda un directorio de nombres para buscar un archivo

    public Caso(String nombre, String descripcion, int n_archivos, String user_id, String eps_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = System.nanoTime();
        this.user_id = user_id;
        this.eps_id = eps_id ;
        this.estado = EstadoCaso.INICIADO;
        this.n_archivos = n_archivos;
    }
    // DB instance
    public Caso(String id,String nombre, String descripcion, String fecha_creacion, String n_archivos, String estado, String user_id, String eps_id, String path){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = Long.parseLong(fecha_creacion);
        this.n_archivos = Integer.parseInt(n_archivos);
        this.estado = EstadoCaso.valueOf(estado);
        this.eps_id = eps_id;
        this.user_id = user_id;
        this.nombre = nombre;
        this.path = path;
    }

    /**
     *
     * Este metodo es necesario para crear y activar el directorio dentro del Path seleccionado
     * Si el Directorio ya existe este no se crea
     */
    public void CrearCarpeta() {
        if(this.user_id != null && this.eps_id != null){
            String path = "src/main/resources/casos/"+this.user_id+'/'+ this.nombre;
            boolean comp = new File(path).mkdirs();
            if(comp){
                this.path = path;
                estado = EstadoCaso.ABIERTO;
            }
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
                arch.get(i).renameTo(new File(this.path + "\\" + name_arch));
                this.docs.add(arch.get(i));
            }
        }
        ActualizarExistencia();
    }
    private void ActualizarExistencia(){
        this.n_archivos = docs.size();
    }

    @Override
    public String toString() {
        return "Caso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", estado=" + estado +
                ", n_archivos=" + n_archivos +
                ", user_id='" + user_id + '\'' +
                ", eps_id='" + eps_id + '\'' +
                ", path='" + path + '\'' +
                ", docs=" + docs +
                '}';
    }
}




