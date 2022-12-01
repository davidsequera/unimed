package com.unimed.view;
import com.unimed.entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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



    public void goCrearCaso(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("CrearCaso");
        CrearCasoController crearCasoController = loader.getController();
        crearCasoController.SetObjectUsuario(appState.getUsuario());
        appState.goPage();
    }

    public void goListCasos(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("ListCasos");
        ListCasosController listCasoController = loader.getController();
//        listCasoController.SetObjectUsuario(EstadoApplication.getInstance().getUsuario());
        appState.goPage();
    }
    public void LogOut(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("LogIn");
        LogInController logInController = loader.getController();
        appState.LogOut();
        appState.goPage();
    }
    public void SetUsuario(){
        Usuario U = ApplicationState.getInstance().getUsuario();
        nombre.setText(U.nombre);
        EPS.setText(U.eps_id);
        edad.setText("Edad: " + U.edad);
        altura.setText("Altura: " + U.altura+"cm");
        peso.setText("Peso: " + U.peso+"kg");
        RH.setText("RH : " + U.RH);
    }
}