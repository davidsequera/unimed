package com.unimed.view;
import com.unimed.entities.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;


public class HomeController  extends Controller{
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


    private Usuario U;

    public HomeController(Stage stage, String  path, double width, double height) {
        super(stage, path, width,height);
    }

    public void start()  {
        this.U = new Usuario("David Millan Perez","EPS Sura",21,1.91,50, "O+");
        this.SetUsuario(U);
        stage.setTitle("UniMed");
        stage.setScene(scene);
        stage.show();
    }

    public void switchtoCrearCaso(ActionEvent event) throws IOException {
        URL url = getClass().getResource("CreateCase.fxml");
        System.out.println(url);
        FXMLLoader loader = new FXMLLoader(url);
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        CreateCaseController C = loader.getController();
        C.SetObjectUsuario(U);
        stage.setScene(scene);
        stage.show();
    }
    public void SetUsuario(Usuario P){
        U = P;
        Nom.setText(P.getName());
        EPS.setText(P.getEPS());
        edad.setText("Edad: " + P.getEdad());
        altura.setText("Altura: " + P.getAltura());
        peso.setText("Peso: " + P.getPeso());
        RH.setText("RH : " + P.getRH());
    }
}