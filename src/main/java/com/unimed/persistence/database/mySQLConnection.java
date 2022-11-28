//package com.unimed.persistence.database;
//
//import com.unimed.entities.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class mySQLConnection implements DatabaseAdapter {
//    private static Connection connection;
//    private static String uri = "jdbc:mysql://localhost:3306/";
//    private static String databaseName = "silverdb";
//    private static String databaseUser = "root";
//    private static String databasePassword = "root";
//
//    private static Statement db ;
//
//    private static mySQLConnection instance;
//
//    private mySQLConnection() {
//        connect();
//    }
//
//    public static mySQLConnection getInstance() {
//        if (instance == null) {
//            instance = new mySQLConnection();
//        }
//        return instance;
//    }
//
//    @Override
//    public void connect(){
//
//        try {
////            getProperties();
//            connection=DriverManager.getConnection(uri+databaseName,databaseUser,databasePassword);
//            connection.setAutoCommit(false);
//            connection.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
//            db =connection.createStatement();
//        } catch ( Exception e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    public void getProperties() throws Exception {
////        try (InputStream input = new FileInputStream("path/to/config.properties")) {
////
////            Properties prop = new Properties();
////
////            // load a properties file
////            prop.load(input);
////
////            // get the property value and print it out
////            System.out.println(prop.getProperty("db.uri"));
////            System.out.println(prop.getProperty("db.user"));
////            System.out.println(prop.getProperty("db.password"));
////
////        } catch (IOException ex) {
////            ex.printStackTrace();
////        }
//
//    }
//
//
//    public void disconnect() {
//        try {
//            connection.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public List<Caso> cosultCasos(String user_id) throws Exception {
//        ArrayList<Caso> products = new ArrayList<>();
//        ResultSet rs= db.executeQuery("SELECT * FROM Caso WHERE user_id = " + user_id);
//        while(rs.next()){
////            products.add(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
//        }
//        return products;
//    }
//
//    @Override
//    public Caso CrateCase(String id, Caso c) throws Exception {
//        try{
//        db.addBatch("INSERT INTO sold_item (nombre, descripcion, n_archivos, estado) VALUES ('"+c.id+"','"+c.product_id+"');");
//        ResultSet rs= db.executeQuery("SELECT * FROM Caso WHERE user_id = " + user_id);
//        while(rs.next()){
//            Caso c1 =(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
//        }
//        connection.commit();
//        return c1;
//        }catch (SQLException e){
//            e.printStackTrace();
//            connection.rollback();
//            throw new Exception("Error al comprar");
//        }
//    }
//    @Override
//    public Credentials logIn(String name) throws Exception {
//        Credentials user;
//        ResultSet rs= db.executeQuery("SELECT credential.user_id , credential.username, credential.password FROM credential WHERE user.username='"+name+"' LIMIT 1;");
//        if(!rs.next()) throw new Exception("Usuario no encontrado");
//            user = new Credentials(rs.getString(1),rs.getString(2),rs.getString(3));
//        return user;
//    }
//    @Override
//    public Credentials signUp(String name, String password) throws Exception {
//        db.executeUpdate("INSERT INTO user (name, password) VALUES ('"+name+"','"+password+"');");
//        connection.commit();
//        ResultSet rs= db.executeQuery("SELECT user.id , user.name, user.password FROM user WHERE user.name='"+name+"' LIMIT 1;");
//        if(!rs.next()) throw new Exception("Usuario no encontrado");
//        Credentials user;
//        user = new Credentials(rs.getString(1),rs.getString(2),rs.getString(3));
//        return user;
//    }
//}
