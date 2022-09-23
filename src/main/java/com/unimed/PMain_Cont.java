package com.unimed;
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


public class PMain_Cont{
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
    private Button B1;
    @FXML
    private Button B2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Dat_Usuario U;

    public void switchtoCrearCaso(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Arch_Browser.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SetUsuario(Dat_Usuario P){
        U = P;
        Nom.setText(P.getName());
        EPS.setText(P.getEPS());
        edad.setText("Edad: " + P.getEdad());
        altura.setText("Altura: " + P.getAltura());
        peso.setText("Peso: " + P.getPeso());
    }
}