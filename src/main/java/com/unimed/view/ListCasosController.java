package com.unimed.view;

import com.unimed.entities.Caso;

import com.unimed.entities.EstadoCaso;
import com.unimed.entities.Usuario;
import com.unimed.persistence.OperationFunction.ConsultarCasos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;



import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class ListCasosController{


    @FXML
    private TableColumn<Caso, String> ColumnName;
    @FXML
    private TableColumn<Caso, String> ColumnDate;

    @FXML
    private TableColumn<Caso, EstadoCaso> ColumnState;

    @FXML
    private TableView<Caso> PropertyList;


    @FXML
    private Button toHomeButton;


    @FXML
    void goHome(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("Home");
        HomeController homeController = loader.getController();
        appState.goPage();
    }

    @FXML
    public void initialize() {
        try {
            loadCasos();
        } catch (IOException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void loadCasos() throws Exception {
        Usuario usuario = ApplicationState.getInstance().getUsuario();
        ConsultarCasos consultarCasos = new ConsultarCasos();
        ArrayList<Caso> casos = new ArrayList<>(consultarCasos.act(usuario.id));
        ObservableList<Caso> list = FXCollections.observableArrayList(
                Objects.requireNonNull(casos)
        );
        ColumnName.setCellValueFactory(new PropertyValueFactory<Caso,String>("nombre"));
        ColumnDate.setCellValueFactory(new PropertyValueFactory<Caso, String>("fecha_creacion_date"));
        ColumnState.setCellValueFactory(new PropertyValueFactory<Caso, EstadoCaso>("estado"));
        PropertyList.setItems(list);
    }

//
//    @FXML
//    void goServices(ActionEvent event) throws IOException {
//        Caso property =PropertyList.getSelectionModel().getSelectedItem();
//        if(property != null){
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("services.fxml"));
//            Parent root = loader.load();
//            ServicesController servicesController = loader.getController();
//            servicesController.setUser(this.getUser());
//            Scene scene = new Scene(root);
//            Stage stage = new Stage();
//            stage.setScene(scene);
//            servicesController.setCaso(property);
//            stage.show();
//            Stage myStage = (Stage) this.btCasoar.getScene().getWindow();
//            myStage.close();
//        }
//    }

}





