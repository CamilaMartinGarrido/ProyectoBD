package visual.controllers;

import dto.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import services.ServicesLocator;
import services.VehicleService;


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
    @FXML
    private ImageView add;
    private VehicleService service;

    public Vehiculos() {
        vehiclesTable = new TableView<Vehicle>();
        service = ServicesLocator.getVehicleService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        license_plate.setCellValueFactory(new PropertyValueFactory<>("license_plate"));
        brand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        luggage_capacity.setCellValueFactory(new PropertyValueFactory<>("luggage_capacity"));
        with_luggage_capacity.setCellValueFactory(new PropertyValueFactory<>("with_luggage_capacity"));
        total_capacity.setCellValueFactory(new PropertyValueFactory<>("total_capacity"));
        year_build.setCellValueFactory(new PropertyValueFactory<>("year_build"));


        try {
            updateVehiclesTable();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //Add vehicle


    //Update vehicle


    //Delete vehicle


    @FXML
    void deleteVehicle(ActionEvent select) throws SQLException {
        int pos = vehiclesTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Vehicle v = vehiclesTable.getItems().get(pos);
            vehiclesTable.getItems().remove(pos);
            service.delete_vehicle(v);
            updateVehiclesTable();
        }

    }

    //Update table
    public void updateVehiclesTable() throws SQLException {
        //Obtener datos
        LinkedList<Vehicle> list = VehicleService.getVehicles();
        //Lista visible
        ObservableList<Vehicle> listaVisible = FXCollections.observableArrayList(list);
        //Establecer datos
        vehiclesTable.setItems(listaVisible);
    }

    //Search
    @FXML
    private void searchVehicles(javafx.scene.input.KeyEvent event) {
    }

    @FXML
    public void addClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Stage window = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogVehiculo.fxml"));

        window.setScene(new Scene(loader.load()));

        window.show();
    }

    public TableView<Vehicle> getTable() {
        return vehiclesTable;
    }

    @FXML
    public void deleteImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteVehicle(select);
    }
}
