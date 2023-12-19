package visual.controllers;

import dto.Package;
import dto.User;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.Control;
import services.PackageService;
import services.ServicesLocator;
import services.VehicleService;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Paquetes implements Initializable {
    public GridPane btnsCRUD;
    //Table
    @FXML
    private TableColumn<Package, String> name;
    @FXML
    private TableColumn<Package, Integer> days;
    @FXML
    private TableColumn<Package, Integer> nights;
    @FXML
    private TableColumn<Package, Integer> pax;
    @FXML
    private TableColumn<Package, Double> transportationCost;
    @FXML
    private TableColumn<Package, Double> totalCost;

    @FXML
    private TableView<Package> packageTable;

    private PackageService service;

    public Paquetes() {
        this.packageTable = new TableView<>();
        service = ServicesLocator.getPackageService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      name.setCellValueFactory(new PropertyValueFactory<>("promotional_name"));
      days.setCellValueFactory(new PropertyValueFactory<>("days_count"));
      nights.setCellValueFactory(new PropertyValueFactory<>("nights_count"));
      pax.setCellValueFactory(new PropertyValueFactory<>("pax_count"));
      transportationCost.setCellValueFactory(new PropertyValueFactory<>("hotel_airport_ride_cost"));
      totalCost.setCellValueFactory(new PropertyValueFactory<>("percent_profit"));
        try {
            updateTable();
        } catch (SQLException  throwables) {
            throwables.printStackTrace();
        }
        permisosRoles();
    }

    public void permisosRoles() {
        User u = Control.getInstance().getSessionUser();
        if (u.getId_role() == 1 || u.getId_role() == 3) {
            btnsCRUD.setVisible(true);
        } else if (u.getId_role() == 2) {
            btnsCRUD.setVisible(false);
        }
    }

    //Insert user
    @FXML
    public void addClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Stage window = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogPaquetes.fxml"));

        window.setScene(new Scene(loader.load()));

        window.show();
    }

    //Update user


    //Delete user
    @FXML
    private void deleteImageClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        ActionEvent select = new ActionEvent();
        delete(select);
    }

    @FXML
    void delete(ActionEvent select) throws SQLException, ClassNotFoundException {
        int pos = packageTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Package p = packageTable.getItems().get(pos);
            packageTable.getItems().remove(pos);
            service.delete_package(p);
            updateTable();
        }

    }

    //Update table
    public void updateTable() throws SQLException {
        //Obtener datos
        LinkedList<Package> list = PackageService.getPackages();
        //Lista visible
        ObservableList<Package> listaVisible = FXCollections.observableArrayList(list);
        //Establecer datos
        packageTable.setItems(listaVisible);
    }

    //Search
    @FXML
    private void searchUsers(javafx.scene.input.KeyEvent event) {
    }

    public void editClicked(MouseEvent mouseEvent) throws IOException {
        int pos = packageTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Package p = packageTable.getItems().get(pos);
            packageTable.getItems().remove(pos);
            Stage window = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/AddPaquetes.fxml"));
            window.setScene(new Scene(loader.load()));
            AddPaquetes controller = loader.getController();
            controller.setId(p.getId_package());
            controller.setCostoViajeHotelAeropuertoField(String.valueOf(p.getTotal_transportation_cost()));
            controller.setCantidadDiasField(String.valueOf(p.getDays_count()));
            controller.setCantidadNochesField(String.valueOf(p.getNights_count()));
            controller.setCantidadPersonasField(String.valueOf(p.getPax_count()));
            controller.setPorcentajeGananciaField(String.valueOf(p.getPercent_profit()));
            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un campo");
        }
    }
}