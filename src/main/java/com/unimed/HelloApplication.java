package com.unimed;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home_UM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 500);
        PMain_Cont C = fxmlLoader.getController();
        Dat_Usuario U = new Dat_Usuario("David Millan Perez","Colsanitas",21,1.90,50);
        C.SetUsuario(U);
        stage.setTitle("UniMed");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}