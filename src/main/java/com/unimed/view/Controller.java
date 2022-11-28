package com.unimed.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

abstract public class Controller {
    protected Stage stage;
    protected Scene scene;
    protected Parent root;

    public Controller(Stage stage, Scene scene, Parent root) {
        this.stage = stage;
        this.scene = scene;
        this.root = root;
    }
    public Controller(Stage stage, String path ,double width, double height) {
        this.stage = stage;
        FXMLLoader loader = new FXMLLoader(HomeController.class.getResource(path));
        try {
            this.scene = new Scene(loader.load(), width, height);
            this.root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
