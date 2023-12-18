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

public class HotelesMenu {
    @FXML
    private JFXButton btnHabitaciones;

    @FXML
    private JFXButton btnHoteles;

    @FXML
    private JFXButton btnTemporada;

    @FXML
    private AnchorPane pnHotelesMenu;

    @FXML
    void habitaciones(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Habitaciones.fxml")));
        pnHotelesMenu.getChildren().removeAll();
        pnHotelesMenu.getChildren().setAll((Node) fxml);
    }

    @FXML
    void hoteles(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Hoteles.fxml")));
        pnHotelesMenu.getChildren().removeAll();
        pnHotelesMenu.getChildren().setAll((Node) fxml);
    }
    @FXML
    void alimentos(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/PlanesAlimenticios.fxml")));
        pnHotelesMenu.getChildren().removeAll();
        pnHotelesMenu.getChildren().setAll((Node) fxml);
    }


    @FXML
    void temporadas(ActionEvent event) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/Temporadas.fxml")));
        pnHotelesMenu.getChildren().removeAll();
        pnHotelesMenu.getChildren().setAll((Node) fxml);
    }

}
