package com.unimed.persistence.database;

import com.unimed.entities.*;
import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class mySQLConnection implements DatabaseAdapter {
    private static Connection connection;
    private static String uri ;
    private static String databaseName;
    private static String databaseUser;
    private static String databasePassword ;
    private static final String properties_path = "src/main/resources/config.properties";

    private static Statement db ;

    private static mySQLConnection instance;

    private mySQLConnection() {
        connect();
    }

    public static mySQLConnection getInstance() {
        if (instance == null) {
            instance = new mySQLConnection();
        }
        return instance;
    }

    @Override
    public void connect(){
        try {
            getProperties();
            connection=DriverManager.getConnection(uri+'/'+databaseName,databaseUser,databasePassword);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            db =connection.createStatement();
        } catch ( Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getProperties()  {
        try (InputStream input = new FileInputStream(properties_path)) {

            Properties prop = new Properties();

            // load a properties file
            prop.load(input);

            uri = prop.getProperty("db.uri") ;
            databaseName = prop.getProperty("db.name");
            databaseUser = prop.getProperty("db.user");
            databasePassword = prop.getProperty("db.password") ;
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    @Override
    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Caso> consultarCasos(String user_id) throws Exception {
        ArrayList<Caso> casos = new ArrayList<>();
        ResultSet rs= db.executeQuery("SELECT * FROM Caso WHERE user_id = '" + user_id+ "'");
        while(rs.next()){
            casos.add(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8), rs.getString(9)   ));
        }
        return casos;
    }

    @Override
    public Caso crearCaso(Caso c) throws Exception {
        try{
            Caso casodb = null;
            db.executeUpdate("INSERT INTO caso (nombre,descripcion,fecha_creacion,n_archivos,estado,user_id,eps_id, path) VALUES ('"+c.nombre+"','"+c.descripcion+"','"+c.fecha_creacion+"','"+c.n_archivos+"','"+c.estado+"','"+c.user_id+"','"+c.eps_id+"','"+c.path+"');");
            ResultSet rs= db.executeQuery("SELECT * FROM caso WHERE user_id = '" + c.user_id+ "' AND eps_id= '" + c.eps_id+ "' AND fecha_creacion= '"+c.fecha_creacion+"' LIMIT 1;");
            while(rs.next()){
                casodb =(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
            connection.commit();
            return casodb;
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new Exception("Error al crear el caso");
        }
    }

    @Override
    public List<Eps> getEPS() throws Exception {
        ArrayList<Eps> eps = new ArrayList<>();
        ResultSet rs= db.executeQuery("SELECT * FROM eps");
        while(rs.next()){
            eps.add(new Eps(rs.getString(1),rs.getString(2)   ));
        }
        return eps;
    }

    @Override
    public Usuario consultarUsuario(String user_id) throws Exception {
        Usuario usuario;
        ResultSet rs= db.executeQuery("SELECT * FROM usuario WHERE id='"+user_id+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Usuario no encontrado");
        usuario = new Usuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        return usuario;
    }

    @Override
    public Credenciales getCredenciales(String user_id) throws Exception {
        Credenciales credenciales;
        ResultSet rs= db.executeQuery("SELECT id,username,password,user_id FROM credenciales WHERE user_id='"+user_id+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Credenciales no encontradas");
        credenciales = new Credenciales(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
        return credenciales;
    }
    @Override
    public Credenciales getCredencialesByUsername(String username) throws Exception {
        Credenciales credenciales;
        ResultSet rs= db.executeQuery("SELECT id,username,password,user_id FROM credenciales WHERE username='"+username+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Credenciales no encontradas");
        credenciales = new Credenciales(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4));
        return credenciales;
    }
    @Override
    public Pair<Credenciales, Usuario> crearUsuario(Credenciales credenciales, Usuario usuario) throws Exception {
        Usuario usuario_db;
        db.executeUpdate("INSERT INTO usuario (nombre,edad,altura,peso,RH, eps_id)  VALUES ('"+usuario.nombre+"','"+usuario.edad+"','"+usuario.altura+"','"+usuario.peso+"','"+usuario.RH+"','"+usuario.eps_id+"');");
        ResultSet rs= db.executeQuery("SELECT id,nombre,edad,altura,peso,RH, eps_id  FROM usuario WHERE nombre='"+usuario.nombre+"' AND edad='"+usuario.edad+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Usuario no encontrado");
        usuario_db = new Usuario(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
        db.executeUpdate("INSERT INTO credenciales (user_id, username, password) VALUES ('"+usuario_db.id+"','"+credenciales.getUsername()+"','"+credenciales.getPassword()+"');");
        connection.commit();
        return new Pair<>(getCredenciales(usuario_db.id), usuario_db);
    }
}
