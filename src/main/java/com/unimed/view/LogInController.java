package com.unimed.view;

import com.unimed.entities.Credenciales;
import com.unimed.entities.Usuario;
import com.unimed.persistence.OperationFunction.LogIn;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.io.IOException;
import java.sql.SQLException;

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
    private Label logInErrorLabel;


    @FXML
    void goSignUp(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("SignUp");
        SignUpController signUpController = loader.getController();
        appState.goPage();
    }
    @FXML
    void LogIn(ActionEvent event)  {
        try {
            Credenciales credenciales = new Credenciales(FieldUsername.getText(), FieldPassword.getText());


            // Crear usuario
            LogIn  logIn = new LogIn();
            Pair<Credenciales, Usuario> result = logIn.act(credenciales);

            ApplicationState appState = ApplicationState.getInstance();
            appState.setUsuario(result.getValue());
            FXMLLoader loader = appState.setPage("Home");
            HomeController homeController = loader.getController();
            appState.goPage();

        }catch (Exception e) {
            // if message
            if(e.getMessage().equals("Credenciales no encontradas") || e.getMessage().equals("[Auth] Credenciales no coinciden")){
                logInErrorLabel.setText("Error credenciales no validas");
            }else {
                logInErrorLabel.setText("Error al iniciar sesion");
                e.printStackTrace();
            }
        }

    }


}
