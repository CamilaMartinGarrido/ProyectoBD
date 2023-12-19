package visual.controllers;

import com.jfoenix.controls.JFXButton;
import dto.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import services.Control;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
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

    private User u;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        u = Control.getInstance().getSessionUser();
        lblUsername.setText(u.getUser_name());
    }

    //Inicio
    public void usuarios(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Usuarios.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void contratos(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Contractos.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void actividadesDiarias(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ActividadesDiarias.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void hoteles(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/HotelesMenu.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void transporte(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Vehiculos.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void paquetes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Paquetes.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void reportes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Reportes.fxml")));
        pnMenu.getChildren().removeAll();
        pnMenu.getChildren().setAll((Node) fxml);
    }
    public void cerrarVentana(javafx.event.ActionEvent actionEvent) {
        Stage stage = (Stage) btnCerrarSesion.getScene().getWindow();
        stage.close();
    }
}
