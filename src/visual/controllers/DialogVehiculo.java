package visual.controllers;

import com.jfoenix.controls.JFXButton;
import dto.Vehicle;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import services.ServicesLocator;
import services.VehicleService;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DialogVehiculo implements Initializable {
    @FXML
    private MFXTextField matricula;

    @FXML
    private MFXTextField marca;

    @FXML
    private MFXTextField capacidadEquipaje;

    @FXML
    private MFXTextField capacidadSinEquipaje;

    @FXML
    private MFXTextField anno;

    @FXML
    private MFXTextField capacidadTotal;

    @FXML
    private Label titulo;

    @FXML
    private JFXButton guardar;

    @FXML
    private JFXButton cancelar;

    @FXML
    private AnchorPane root;
    private Vehiculos v = new Vehiculos();
    private VehicleService service;
    private int id;

    public DialogVehiculo() {
        service = ServicesLocator.getVehicleService();
    }


    @FXML
    private void cancelarClicked() {
        // Lógica del botón Cancelar
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
public void setId(int value){
        id = value;
}
    public void setMatricula(String value) {
        matricula.setText(value);
    }

    public void setMarca(String value) {
        marca.setText(value);
    }

    public void setCapacidadEquipaje(String value) {
        capacidadEquipaje.setText(value);
    }

    public void setCapacidadSinEquipaje(String value) {
        capacidadSinEquipaje.setText(value);
    }

    public void setAnno(String value) {
        anno.setText(value);
    }

    public void setCapacidadTotal(String value) {
        capacidadTotal.setText(value);
    }

    @FXML
    public void guardarClicked(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        String plate = matricula.getText();
        String brand = marca.getText();
        Double luggageCapacity = Double.parseDouble(capacidadEquipaje.getText());
        Double totalCapacity = Double.parseDouble(capacidadTotal.getText());
        Double whithLuggage = Double.parseDouble(capacidadSinEquipaje.getText());
        int year = Integer.parseInt(anno.getText());

        Vehicle vehicle = new Vehicle(id,plate, brand, luggageCapacity, whithLuggage, totalCapacity, year);
        if (service.findVehicle(vehicle) == true) {
            service.update_vehicle(vehicle);
        } else {
            Vehicle aux = new Vehicle(plate, brand, luggageCapacity, whithLuggage, totalCapacity, year);
            TableView<Vehicle> t = v.getTable();
            t.getItems().add(aux);
            service.add_vehicle(aux);
        }


        v.getTable().refresh();
    }
}
