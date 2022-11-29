package com.unimed.view;
import com.unimed.entities.Usuario;
import com.unimed.view.CreateCaseController;
import com.unimed.view.EstadoApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;


public class HomeController {
    @FXML
    private Label nombre;
    @FXML
    private Label EPS;
    @FXML
    private Label edad;
    @FXML
    private Label altura;
    @FXML
    private Label peso;
    @FXML
    private Label RH;
    @FXML
    private Button CrearCasoButton;
    @FXML
    private Button verCasosButton;
    @FXML
    private Button generarReporteButton;

    @FXML
    private Button LogOutButton;

    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchtoCrearCaso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CrearCaso.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        CreateCaseController C = loader.getController();
        C.SetObjectUsuario(EstadoApplication.getInstance().getUsuario());
        stage.setScene(scene);
        stage.show();
    }

    public void goListCasos(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ListCasos.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        ListCasosController C = loader.getController();
//        C.SetObjectUsuario(EstadoApplication.getInstance().getUsuario());
        stage.setScene(scene);
        stage.show();
    }
    public void LogOut(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LogIn.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        LogInController logInController = loader.getController();
        stage.setScene(scene);
        stage.show();
    }
    public void SetUsuario(){
        Usuario U = EstadoApplication.getInstance().getUsuario();
        nombre.setText(U.nombre);
        EPS.setText(U.EPS);
        edad.setText("Edad: " + U.edad);
        altura.setText("Altura: " + U.altura);
        peso.setText("Peso: " + U.peso);
        RH.setText("RH : " + U.RH);
    }
}