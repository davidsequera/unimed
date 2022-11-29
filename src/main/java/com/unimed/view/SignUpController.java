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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        LogInController logInController = loader.getController();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void signIn(ActionEvent event) throws IOException {
//        Usuario user = auth.signUp(TextEmail.getText(),TextPassword.getText(),TextNombre.getText(),TextApellido.getText());
//        if(user != null) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("list.fxml"));
//            Parent root = loader.load();
//            ListController listController = loader.getController();
//            listController.setUser(user);
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            stage.show();
//            Stage myStage = (Stage) this.singUpButton.getScene().getWindow();
//            myStage.close();
//        }
    }

}
