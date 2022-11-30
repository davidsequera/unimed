package com.unimed;

import com.unimed.view.ApplicationState;
import com.unimed.view.LogInController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ApplicationState state =  ApplicationState.getInstance();

        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("view/LogIn.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root, 350, 517);

        LogInController logInController = loader.getController();
        state.setScene(scene);
        state.setStage(stage);
        state.setRoot(root);


        stage.setTitle("Unimed");
        stage.setScene(scene);
        stage.show();
    }
}