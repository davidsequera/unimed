package com.unimed.persistence.database;

import com.unimed.entities.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class mySQLConnection implements DatabaseAdapter {
    private static Connection connection;
    private static String uri = "jdbc:mysql://localhost:3306/";
    private static String databaseName = "unimed";
    private static String databaseUser = "root";
    private static String databasePassword = "root";

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
//            getProperties();
            connection=DriverManager.getConnection(uri+databaseName,databaseUser,databasePassword);
            connection.setAutoCommit(false);
            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
            db =connection.createStatement();
        } catch ( Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void getProperties() throws Exception {
//        try (InputStream input = new FileInputStream("path/to/config.properties")) {
//
//            Properties prop = new Properties();
//
//            // load a properties file
//            prop.load(input);
//
//            // get the property value and print it out
//            System.out.println(prop.getProperty("db.uri"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }

    }


    public void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Caso> cosultarCasos(String user_id) throws Exception {
        ArrayList<Caso> casos = new ArrayList<>();
        ResultSet rs= db.executeQuery("SELECT * FROM Caso WHERE user_id = " + user_id);
        while(rs.next()){
            casos.add(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7) ));
        }
        return casos;
    }

    @Override
    public Caso crearCaso(String id, Caso c) throws Exception {
        try{
            Caso casodb = null;
            db.addBatch("INSERT INTO sold_item (id,user_id,nombre, descripcion, n_archivos, estado) VALUES ('"+c.user_id+"','"+c.nombre+"','"+c.descripcion+"','"+c.n_archivos+"','"+c.nombre+"','"+c.descripcion+"','"+c.nombre+"','"+c.descripcion+"');");
            ResultSet rs= db.executeQuery("SELECT * FROM Caso WHERE user_id = " + id);
            while(rs.next()){
                casodb =(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
            }
            connection.commit();
            return casodb;
        }catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            throw new Exception("Error al comprar");
        }
    }

    @Override
    public Usuario consultarUsuario(String user_id) throws Exception {
        return null;
    }

    @Override
    public Credenciales logIn(String username) throws Exception {
        Credenciales credenciales;
        ResultSet rs= db.executeQuery("SELECT * FROM credential WHERE username='"+username+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Usuario no encontrado");
            credenciales = new Credenciales(rs.getString(1),rs.getString(2),rs.getString(3));
        return credenciales;
    }
    @Override
    public Credenciales signUp(Credenciales credenciales, Usuario usuario) throws Exception {
        db.executeUpdate("INSERT INTO credenciales (user_id, username, password) VALUES ('"+credenciales.getUser()+"','"+credenciales.getPassword()+"');");
        db.executeUpdate("INSERT INTO user (nombre,EPS,edad,altura,peso,RH)  VALUES ('"+usuario.nombre+"','"+usuario.EPS+"','"+usuario.edad+"','"+usuario.altura+"','"+usuario.altura+"');");
        connection.commit();
        ResultSet rs= db.executeQuery("SELECT id,nombre,EPS,edad,altura,peso,RH FROM usuario WHERE id='"+usuario.id+"' LIMIT 1;");
        if(!rs.next()) throw new Exception("Usuario no encontrado");
        Credenciales user;
        user = new Credenciales(rs.getString(1),rs.getString(2),rs.getString(3));
        return user;
    }
}
