package com.unimed.view;

import com.unimed.entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LogInController{

    @FXML
    private TextField FieldUsername;
    @FXML
    private PasswordField FieldPassword;

    @FXML
    private Button LogInButton;

    @FXML
    private Button SignUpButton;



    @FXML
    void goSignUp(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("SignUp");
        SignUpController signUpController = loader.getController();
        appState.goPage();
    }
    @FXML
    void LogIn(ActionEvent event) throws IOException {
//        Owner u = auth.logIn(TextUsuario.getText(),TextPassword.getText());
//        if(u != null ) {
//            this.goIn(u);
//        }
        // Usuario mock
        Usuario U = new Usuario("David Millan Perez",20,1.91,60,"O+", "63865b81163842e07000002e");
        ApplicationState appState = ApplicationState.getInstance();
        appState.setUsuario(U);

        FXMLLoader loader = appState.setPage("Home");
        HomeController homeController = loader.getController();
        homeController.SetUsuario();
        appState.goPage();

    }


}
