//package com.unimed.persistence.database;
//
//import com.unimed.entities.*;
//
//import java.sql.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class mySQLConnection implements DatabaseMapper {
//    private static Connection connection;
//    private static String uri = "jdbc:mysql://localhost:3306/";
//    private static String databaseName = "silverdb";
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
//            connection=DriverManager.getConnection(uri+databaseName,"root","root");
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
//    public List<Caso> cosult() throws Exception {
//        ArrayList<Caso> products = new ArrayList<>();
//        ResultSet rs= db.executeQuery("SELECT product.id, product.name, product.price, COUNT(product.id) as stock FROM product JOIN item ON product.id = item.product_id GROUP BY product.id;");
//        while(rs.next()){
////            products.add(new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
//        }
//        return products;
//    }
//
//    @Override
//    public Caso buy(String id) throws Exception {
//        Caso product;
//        try{
//
//        ResultSet rs= db.executeQuery("SELECT item.id, product.id , product.name, product.price FROM product JOIN item ON product.id = item.product_id WHERE product.id='"+id+"' LIMIT 1;");
//        if(!rs.next()) throw new Exception("No hay stock");
////        product = new Caso(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
//        db.addBatch("INSERT INTO sold_item (id, product_id) VALUES ('"+product.id+"','"+product.product_id+"');");
//        db.addBatch("DELETE FROM item WHERE id='"+product.id+"';");
//        db.executeBatch();
//        connection.commit();
//        return product;
//        }catch (SQLException e){
//            e.printStackTrace();
//            connection.rollback();
//            throw new Exception("Error al comprar");
//        }
//    }
//    @Override
//    public Dat_Usuario logIn(String name) throws Exception {
//        Dat_Usuario user;
//        ResultSet rs= db.executeQuery("SELECT user.id , user.name, user.password FROM user WHERE user.name='"+name+"' LIMIT 1;");
//        if(!rs.next()) throw new Exception("Usuario no encontrado");
////        user = new Dat_Usuario(rs.getString(1),rs.getString(2),rs.getString(3));
//        return user;
//    }
//    @Override
//    public Dat_Usuario signUp(String name, String password) throws Exception {
//        db.executeUpdate("INSERT INTO user (name, password) VALUES ('"+name+"','"+password+"');");
//        connection.commit();
//        ResultSet rs= db.executeQuery("SELECT user.id , user.name, user.password FROM user WHERE user.name='"+name+"' LIMIT 1;");
//        if(!rs.next()) throw new Exception("Usuario no encontrado");
//        Dat_Usuario user;
////        user = new Dat_Usuario(rs.getString(1),rs.getString(2),rs.getString(3));
//        return user;
//    }
//}
