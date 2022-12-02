package com.unimed.view;

import com.unimed.entities.Caso;
import com.unimed.entities.Usuario;

import com.unimed.persistence.OperationFunction.CrearCaso;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private TextField FieldNombre;
    @FXML
    private TextArea FieldDescripcion;
    @FXML
    private Button crearCasoButton;
    @FXML
    private Button seleccionarArchivosButton;
    @FXML
    private Button cargarArchivosButton;
    @FXML
    private Label selectedArchivosLabel;
    @FXML
    private Label successCaseLabel;
    @FXML
    private Label successArchivoLabel;
    @FXML
    private Button goHomeButton;

    private Caso casoActual; //Caso creado que se esta trabajando

    private List<File> casoAchivosList; //Lista de archivos a agregar al caso

    /**
     * Metodo para abrir explorador de archivos y adquirir el path
     */
    @FXML
    private void crearCaso(ActionEvent e){
        Usuario usuario = ApplicationState.getInstance().getUsuario();
        this.casoActual = new Caso(FieldNombre.getText(),FieldDescripcion.getText(), 0, usuario.id, usuario.eps_id);
        if (this.casoActual.crearCarpeta()) successCaseLabel.setText("El caso se ha creado exitosamente!");
    }
    @FXML
    private void seleccionarArchivos(ActionEvent e){
        File archivo = importarArchivo();
        casoAchivosList.add(archivo);
        selectedArchivosLabel.setText(casoAchivosList.stream().reduce("", (a, b) -> a + b.getName() + "\n", String::concat));
    }
    @FXML
    private void cargarArchivos(ActionEvent e){
        CrearCaso crearCaso = new CrearCaso();
        try {
            guardarArchivos(casoAchivosList);
            crearCaso.act(this.casoActual);
            successArchivoLabel.setText("Caso creado y archivos Cargados con exito!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    private File importarArchivo ()
    {
        Stage display = new Stage();
        FileChooser selecArchivo = new FileChooser();
        selecArchivo.setTitle("File Explorer");
        selecArchivo.getExtensionFilters().add(new FileChooser.ExtensionFilter("All Files", "*.*"));
        return  selecArchivo.showOpenDialog(display);
    }


    /**
     *
     * @param archivos, Lista de tipo archivo
     * Este metodo contiene una rutina para guardar un archivo dado en el directorio del caso
     */
    private void guardarArchivos(List<File> archivos) throws IOException {
        if(archivos.size() == 0){ return;}
            for (File archivo: archivos) {
                File copied = new File(this.casoActual.getPath() + "\\" + archivo.getName());
                com.google.common.io.Files.copy(archivo, copied);
                this.casoActual.getDocs().add(archivo);
            }
            actualizarExistencia();
    }
    private void actualizarExistencia(){
        // TODO : Actualizar la existencia de archivos en la base de datos
        this.casoActual.setN_archivos(this.casoActual.getDocs().size());
    }

    public void goHome(ActionEvent event) throws IOException {
        casoAchivosList.clear();
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("Home");
        HomeController homeController = loader.getController();
        appState.goPage();
    }
    @FXML
    private void initialize(){
        this.casoAchivosList = new ArrayList<>();
    }
}

