package visual.controllers;

import dto.Package;
import dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.PackageService;
import services.ServicesLocator;

import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Paquetes implements Initializable {
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
    private TableColumn<Package, Double> hotelCost;
    @FXML
    private TableColumn<Package, Double> transportationCost;
    @FXML
    private TableColumn<Package, Double> totalCost;

    @FXML
    private TableView<Package> packageTable;

    private PackageService service;

    public Paquetes() {
        packageTable = new TableView<>();
        service = ServicesLocator.getPackageService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
name.setCellValueFactory(new PropertyValueFactory<>("promotional_name"));
days.setCellValueFactory(new PropertyValueFactory<>("days_count"));
nights.setCellValueFactory(new PropertyValueFactory<>("nights_count"));
pax.setCellValueFactory(new PropertyValueFactory<>("pax_count"));
hotelCost.setCellValueFactory(new PropertyValueFactory<>("total_hotel_cost"));
transportationCost.setCellValueFactory(new PropertyValueFactory<>("total_transportation_cost"));
totalCost.setCellValueFactory(new PropertyValueFactory<>("total_package_cost"));
        try {
            updateTable();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    //Insert user


    //Update user


    //Delete user
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        ActionEvent select = new ActionEvent();
        deleteUser(select);
    }

    @FXML
    void deleteUser(ActionEvent select) throws SQLException, ClassNotFoundException {
        int pos = packageTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            ServicesLocator.getUserService().deleteUser(ServicesLocator.getUserService().getUsers().get(pos));
            updateTable();
        }

    }

    //Update table
    public void updateTable() throws SQLException, ClassNotFoundException {
        LinkedList<Package> list = PackageService.getPackages();
        ObservableList<Package> visibleList = FXCollections.observableArrayList(list);
        packageTable.setItems(visibleList);
    }

    //Search
    @FXML
    private void searchUsers(javafx.scene.input.KeyEvent event) {
    }
}