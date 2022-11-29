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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        SignUpController signUpController = loader.getController();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void LogIn(ActionEvent event) throws IOException {
//        Owner u = auth.logIn(TextUsuario.getText(),TextPassword.getText());
//        if(u != null ) {
//            this.goIn(u);
//        }
    }
    @FXML
    protected void goIn(Usuario o) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
        Parent root = loader.load();
//        ListController listController = loader.getController();
//        listController.setUser(o);
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        Stage myStage = (Stage) this.SignUpButton.getScene().getWindow();
        myStage.close();
    }

}
