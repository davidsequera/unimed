package com.unimed.view;

import com.unimed.entities.Credenciales;
import com.unimed.entities.Eps;
import com.unimed.entities.Usuario;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ApplicationState {


    private static ApplicationState instance;
    private Usuario usuario;
    private Credenciales credenciales;
    private HashMap<String, Eps> epsList;


    private Stage stage;
    private Scene scene;
    private Parent root;


    private ApplicationState(){}
    public static ApplicationState getInstance(){
        if(instance == null){
            instance = new ApplicationState();
        }
        return instance;
    }

    public void setUsuario(Usuario usuario) { this.usuario = usuario;}
    public Usuario getUsuario() {
        return usuario;
    }
    public void setCredenciales(Credenciales credenciales) {this.credenciales = credenciales;}
    public Credenciales getCredenciales() { return credenciales;}

    public void LogOut(){
        usuario = null;
        credenciales = null;
    }

    public boolean isLogged(){
        return usuario != null;
    }


    public FXMLLoader setPage(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(path+".fxml"));
        root = loader.load();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        return loader;
    }

    public void goPage()  {
        stage.setScene(scene);
        stage.show();
    }


    public Stage getStage() {
        return stage;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Parent getRoot() {
        return root;
    }

    public void setRoot(Parent root) {
        this.root = root;
    }

    public HashMap<String, Eps> getEpsList() {
        return epsList;
    }

    public void setEpsList(ArrayList<Eps> epsList) {
        if(this.epsList == null){
            this.epsList = new HashMap<>();
        }
        for (Eps eps : epsList){
            this.epsList.put(eps.nombre, eps);
        }
    }
}
