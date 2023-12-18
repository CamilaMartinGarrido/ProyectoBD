package visual.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class Transportes {
    @FXML
    private JFXButton btnModelos;

    @FXML
    private JFXButton btnVehiculos;

    @FXML
    private AnchorPane pnTransportes;

    @FXML
    void modelos(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ModelosTransporte.fxml")));
        pnTransportes.getChildren().removeAll();
        pnTransportes.getChildren().setAll((Node) fxml);
    }

    @FXML
    void transportes(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Vehiculos.fxml")));
        pnTransportes.getChildren().removeAll();
        pnTransportes.getChildren().setAll((Node) fxml);
    }
}
