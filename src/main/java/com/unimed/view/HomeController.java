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
    private Label Nom;
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
    private Button B1;
    @FXML
    private Button B2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Usuario U;

    public void switchtoCrearCaso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("CreateCase.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        CreateCaseController C = loader.getController();
        C.SetObjectUsuario(EstadoApplication.getInstance().getUsuario());
        stage.setScene(scene);
        stage.show();
    }
    public void SetUsuario(Usuario P){
        U = P;
        Nom.setText(P.nombre);
        EPS.setText(P.EPS);
        edad.setText("Edad: " + P.edad);
        altura.setText("Altura: " + P.altura);
        peso.setText("Peso: " + P.peso);
        RH.setText("RH : " + P.RH);
    }
}