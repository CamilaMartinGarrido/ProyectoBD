package visual.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Inicio implements Initializable {
    @FXML
    private JFXButton btnCerrarSesion;

    @FXML
    private JFXButton btnContratos;

    @FXML
    private JFXButton btnHoteles;

    @FXML
    private JFXButton btnInicio;

    @FXML
    private JFXButton btnPaquetes;

    @FXML
    private JFXButton btnReportes;

    @FXML
    private JFXButton btnServicios;

    @FXML
    private JFXButton btnTransporte;

    @FXML
    private JFXButton btnUser;

    @FXML
    private Label lblUsername;

    @FXML
    private Pane pnMenu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //Inicio
    public void usuarios(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Usuarios.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void contratos(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Contratos.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void actividadesDiarias(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ActividadesDiarias.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void hoteles(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Vehiculos.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void Transporte(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Vehiculos.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }

}
