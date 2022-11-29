package com.unimed;

import com.unimed.entities.Usuario;
import com.unimed.view.EstadoApplication;
import com.unimed.view.HomeController;
import com.unimed.view.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("view/LogIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 517);
        LogInController logInController = fxmlLoader.getController();
        stage.setTitle("UniMed");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}