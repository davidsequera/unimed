package com.unimed.view;

import com.unimed.entities.Caso;
import com.unimed.entities.Usuario;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.Node;


import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ListCasosController {

    @FXML
    private TableColumn<Caso, String> ColumnLocation;

    @FXML
    private TableColumn<Caso, String> ColumnName;

    @FXML
    private TableColumn<Caso, Integer> ColumnPrice;

    @FXML
    private TableView<Caso> PropertyList;


    @FXML
    private Button toHomeButton;


    @FXML
    void goHome(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        HomeController homeController = loader.getController();
        homeController.SetUsuario();
        stage.setScene(scene);
        stage.show();
    }

//    IListProperties listProperties = new ListProperties();
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        try {
//            LoadData();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//    private void LoadData() throws IOException {
//        ObservableList<Caso> list = FXCollections.observableArrayList(
//                Objects.requireNonNull(listProperties.listarPropiedades())
//        );
//        ColumnName.setCellValueFactory(new PropertyValueFactory<Caso,String>("nombre"));
//        ColumnLocation.setCellValueFactory(new PropertyValueFactory<Caso, String>("lugar"));
//        ColumnPrice.setCellValueFactory(new PropertyValueFactory<Caso,Integer>("precio"));
//        PropertyList.setItems(list);
//
//    }



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





