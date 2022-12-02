package com.unimed.view;

import com.unimed.entities.Credenciales;
import com.unimed.entities.Eps;
import com.unimed.entities.Usuario;

import com.unimed.persistence.OperationFunction.GetEPS;
import com.unimed.persistence.OperationFunction.SignUp;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SignUpController{


    @FXML
    private TextField FieldNombre;
    @FXML
    private TextField FieldEdad;
    @FXML
    private TextField FieldAltura;
    @FXML
    private TextField FieldPeso;
    @FXML
    private TextField FieldRH;
    @FXML
    private ChoiceBox choiceBoxEPS;

    @FXML
    private TextField FieldUsername;
    @FXML
    private PasswordField FieldPassword;

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
    void signUp(ActionEvent event)  {
        // Casting datos
        try {
            ApplicationState a = ApplicationState.getInstance();
            int edad = Integer.parseInt(FieldEdad.getText());
            double altura = Double.parseDouble(FieldAltura.getText());
            double peso = Double.parseDouble(FieldPeso.getText());
            String eps_id = a.getEpsList().get(choiceBoxEPS.getValue().toString()).id;
            if(eps_id == null){
                throw new Exception("No se ha seleccionado una EPS");
            }
            Usuario usuario = new Usuario(FieldNombre.getText(), edad, altura, peso, FieldRH.getText(),  eps_id);


            Credenciales credenciales = new Credenciales(FieldUsername.getText(), FieldPassword.getText());


            // Crear usuario
            SignUp signUp = new SignUp();
            Pair<Credenciales, Usuario> result = signUp.act(credenciales,usuario);
            if(result.getValue() == null || result.getKey() == null){
                throw  new Exception("Error al crear usuario");
                //TODO mostrar mensaje de error
            }else{
                ApplicationState appState = ApplicationState.getInstance();
                appState.setUsuario(result.getValue());
                FXMLLoader loader = appState.setPage("Home");
                HomeController homeController = loader.getController();
                appState.goPage();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void  initialize(){
        try {
            getEps();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void getEps() throws Exception {
        GetEPS getEps = new GetEPS();
        ArrayList<Eps> listEps = new ArrayList<>(getEps.act());
        ApplicationState a = ApplicationState.getInstance();
        a.setEpsList(listEps);

        choiceBoxEPS.getItems().clear();
        for (Eps eps : listEps) {
            choiceBoxEPS.getItems().add(eps.nombre);
        }
    }
}
