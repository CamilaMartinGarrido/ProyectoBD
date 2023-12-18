package visual.controllers;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class Contratos implements Initializable {

    @FXML
    private AnchorPane pnContrato;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }
    public void hoteles(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ContratosHoteles.fxml")));
        pnContrato.getChildren().removeAll();
        pnContrato.getChildren().setAll((Node) fxml);
    }
    public void transportes(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ContratosTransportes.fxml")));
        pnContrato.getChildren().removeAll();
        pnContrato.getChildren().setAll((Node) fxml);
    }
    public void servicios(javafx.event.ActionEvent actionEvent) throws IOException {
        Parent fxml = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/visual/views/ContratosServicios.fxml")));
        pnContrato.getChildren().removeAll();
        pnContrato.getChildren().setAll((Node) fxml);
    }

}
