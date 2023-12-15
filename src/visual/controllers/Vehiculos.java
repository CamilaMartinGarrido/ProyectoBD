package visual.controllers;
import dto.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Vehiculos implements Initializable {
    //Table
    @FXML
    private TableColumn<Vehiculos, String> license_plate;
    @FXML
    private TableColumn<Vehiculos, String> brand;
    @FXML
    private TableColumn<Vehiculos, Double> luggage_capacity;
    @FXML
    private TableColumn<Vehiculos, Double> with_luggage_capacity;
    @FXML
    private TableColumn<Vehiculos, Double> total_capacity;
    @FXML
    private TableColumn<Vehiculos, Integer> year_build;
    @FXML
    private TableView<Vehicle> vehiclesTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert vehicle


    //Update vehicle


    //Delete vehicle
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteVehicle(select);
    }

    @FXML
    void deleteVehicle(ActionEvent select) {
        int pos = vehiclesTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateVehiclesTable();
        }

    }

    //Update table
    public void updateVehiclesTable(){
        // Coding
    }

}
