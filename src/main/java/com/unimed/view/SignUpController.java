package com.unimed.view;

import com.unimed.entities.Caso;
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
import java.util.List;

public class SignUpController{


    @FXML
    private TextField FieldNombre;
    @FXML
    private TextField FieldEPS;
    @FXML
    private TextField FieldEdad;
    @FXML
    private TextField FieldAltura;
    @FXML
    private TextField FieldPeso;
    @FXML
    private TextField FieldRH;

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Button signUpButton;

    @FXML
    private Button logInButton;



    @FXML
    void goLogIn(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();

        FXMLLoader loader = appState.setPage("LogIn");
        LogInController logInController = loader.getController();
        appState.goPage();
    }
    @FXML
    void signIn(ActionEvent event) throws IOException {
//        Usuario U = auth.signUp(TextEmail.getText(),TextPassword.getText(),TextNombre.getText(),TextApellido.getText());
        Usuario U = new Usuario("David Millan Perez",20,1.91,60,"O+", "63865b81163842e07000002e");
        ApplicationState appState = ApplicationState.getInstance();
        appState.setUsuario(U);

        FXMLLoader loader = appState.setPage("Home");
        HomeController homeController = loader.getController();
        homeController.SetUsuario();
        appState.goPage();
    }

}
