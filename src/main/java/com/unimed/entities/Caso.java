package com.unimed.entities;
import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Caso {

    private String id;

    private static final String PATH = "src/main/resources/casos";

    // Nombre que va a tener el caso
    private String nombre;
    private String descripcion; //Pequeña descripcion de la informacion dentro del caso
    private final long fecha_creacion; // Fecha en la que se crea el caso
    private final String fecha_creacion_date;
    private EstadoCaso estado; //El caso esta activo o no
    private int n_archivos; // Cantidad de archivos presentes en el caso
    private String user_id;
    private String eps_id;
    private String path; // Path hacia donde existe el directorio
    private List<File> docs = new ArrayList<>(); // Guarda un directorio de nombres para buscar un archivo

    public Caso(String nombre, String descripcion, int n_archivos, String user_id, String eps_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_creacion = System.currentTimeMillis();
        this.fecha_creacion_date = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date(fecha_creacion));
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
        this.fecha_creacion_date = (new SimpleDateFormat("dd/MM/yyyy")).format(new Date(this.fecha_creacion));
        this.n_archivos = Integer.parseInt(n_archivos);
        this.estado = EstadoCaso.valueOf(estado);
        this.eps_id = eps_id;
        this.user_id = user_id;
        this.path = path;
    }

    /**
     *
     * Este metodo es necesario para crear y activar el directorio dentro del Path seleccionado
     * Si el Directorio ya existe este no se crea
     */
    public boolean crearCarpeta() {
        if(this.user_id == null || this.eps_id == null){ return false;}
        String path = PATH+'/'+this.user_id+'/'+ this.nombre;
        boolean dir_created = new File(path).mkdirs();
        if(!dir_created){return false;}
        this.path = path;
        estado = EstadoCaso.ABIERTO;
        return true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getFecha_creacion() {
        return fecha_creacion;
    }

    public String getFecha_creacion_date() { return fecha_creacion_date;}

    public EstadoCaso getEstado() {
        return estado;
    }

    public void setEstado(EstadoCaso estado) {
        this.estado = estado;
    }

    public int getN_archivos() {
        return n_archivos;
    }

    public void setN_archivos(int n_archivos) {
        this.n_archivos = n_archivos;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEps_id() {
        return eps_id;
    }

    public void setEps_id(String eps_id) {
        this.eps_id = eps_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public List<File> getDocs() {
        return docs;
    }

    public void setDocs(List<File> docs) {
        this.docs = docs;
    }



    @Override
    public String toString() {
        return "Caso{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fecha_creacion=" + fecha_creacion +
                ", fecha_creacion_date=" + fecha_creacion_date +
                ", estado=" + estado +
                ", n_archivos=" + n_archivos +
                ", user_id='" + user_id + '\'' +
                ", eps_id='" + eps_id + '\'' +
                ", path='" + path + '\'' +
                ", docs=" + docs +
                '}';
    }
}




