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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrearCasoController {
    @FXML
    private Label L1;
    @FXML
    private Label L2;
    @FXML
    private Label L3;
    @FXML
    private Button B1;
    @FXML
    private Button B2;
    @FXML
    private Button B3;
    @FXML
    private Button B4;
    @FXML
    private TextField T1;
    @FXML
    private TextArea T2;

    private Stage stage;
    private Scene scene;
    private Parent root;

    private Caso N_Caso; //Caso creado que se esta trabajando

    private List<File> Agreg; //Lista de archivos a agregar al caso

    /**
     * Metodo para abrir explorador de archivos y adquirir el path
     */
    @FXML
    private File ImportarArch ()
    {
        Stage display = new Stage();
        FileChooser selecArch = new FileChooser();
        selecArch.setTitle("File Explorer");
        selecArch.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        return  selecArch.showOpenDialog(display);
    }
    public void CargarArchs(ActionEvent e){
       File Arch = ImportarArch();
       Agreg.add(Arch);
       String Report = "";
       for(int i = 0; i < Agreg.size();i++){
           Report = Report + Agreg.get(i).getName() + "\n";
       }
       L1.setText(Report);
    }
    public void SubirArchs(ActionEvent e){
        Usuario U = ApplicationState.getInstance().getUsuario();
        L3.setText("Archivos Cargados con exito!");
        N_Caso.GuardarArchivos(Agreg);
        U.addCaso(N_Caso);
    }
    public void CrearCaso(ActionEvent e){
        Usuario U = ApplicationState.getInstance().getUsuario();
        String nombre = T1.getText();
        String descripcion = T2.getText();
        this.N_Caso = new Caso(nombre,descripcion, 0, U.id, U.eps_id);
        this.N_Caso.CrearCarpeta();
        L2.setText("El caso se ha creado exitosamente!");
    }
    public void goHome(ActionEvent event) throws IOException {
        Agreg.clear();
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("Home");
        HomeController homeController = loader.getController();
        homeController.SetUsuario();
        appState.goPage();
    }
    public void SetObjectUsuario(Usuario usuario){
        // TODO: Implement this method
        Agreg = new ArrayList(usuario.casos);
    }
}

