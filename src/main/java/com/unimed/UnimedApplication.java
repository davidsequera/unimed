package com.unimed;


import com.unimed.view.HomeController;
import javafx.application.Application;
import javafx.stage.Stage;

public class UnimedApplication extends Application {
    @Override
    public void start(Stage stage) {
        HomeController home = new HomeController(stage, "Home.fxml",500,300);

        home.start();
    }
}
