package com.unimed.view;
import com.unimed.entities.Eps;
import com.unimed.entities.Usuario;
import com.unimed.persistence.OperationFunction.CrearReporte;
import com.unimed.persistence.OperationFunction.GetEPS;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Stream;


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
    private Label reporteLabel;

    @FXML
    private Button LogOutButton;



    public void goCrearCaso(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("CrearCaso");
        CrearCasoController crearCasoController = loader.getController();
        appState.goPage();
    }

    public void goListCasos(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("ListCasos");
        ListCasosController listCasoController = loader.getController();
        appState.goPage();
    }

    public void generarReporte(ActionEvent event)  {
        try {
            ApplicationState appState = ApplicationState.getInstance();
            CrearReporte crearReporte = new CrearReporte();
            crearReporte.act(appState.getUsuario().id);
            reporteLabel.setText("Se ha creado el reporte");
        }catch (Exception e){
            reporteLabel.setText("Ha ocurrido un error");
            reporteLabel.setTextFill(javafx.scene.paint.Color.RED);
            e.printStackTrace();
        }
    }

    public void LogOut(ActionEvent event) throws IOException {
        ApplicationState appState = ApplicationState.getInstance();
        FXMLLoader loader = appState.setPage("LogIn");
        LogInController logInController = loader.getController();
        appState.LogOut();
        appState.goPage();
    }

    public void initialize(){
        try{
            getEps();
            setUsuario();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void setUsuario() {
        ApplicationState state = ApplicationState.getInstance();
        Usuario U = ApplicationState.getInstance().getUsuario();
        Stream<Eps> eps = state.getEpsList().values().stream();
        // Find the EPS
        Eps epsUsuario = eps.filter(e -> U.eps_id.equals(e.id)).findFirst().orElse(null);
        nombre.setText(U.nombre);
        EPS.setText(epsUsuario.nombre);
        edad.setText("Edad: " + U.edad);
        altura.setText("Altura: " + U.altura+"cm");
        peso.setText("Peso: " + U.peso+"kg");
        RH.setText("RH : " + U.RH);
    }

    public void getEps() throws Exception {
        GetEPS getEps = new GetEPS();
        ArrayList<Eps> listEps = new ArrayList<>(getEps.act());
        ApplicationState a = ApplicationState.getInstance();
        a.setEpsList(listEps);
    }
}