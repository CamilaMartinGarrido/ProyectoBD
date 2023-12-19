package visual.controllers;

import com.jfoenix.controls.JFXButton;
import dto.Contract;
import dto.Package;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import services.ContractService;
import services.PackageService;
import services.ServicesLocator;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AddPaquetes implements Initializable {
    @FXML
    private MFXTextField costoViajeHotelAeropuertoField;
    @FXML
    private MFXTextField nombrePromocionalField;
    @FXML
    private MFXTextField cantidadDiasField;
    @FXML
    private MFXTextField cantidadNochesField;
    @FXML
    private MFXTextField cantidadPersonasField;
    @FXML
    private MFXTextField porcentajeGananciaField;
    @FXML
    private TableView<Contract> contractsTable;
    @FXML
    private TableColumn<Contract, String> contractTypeColumn;
    @FXML
    private TableColumn<Contract, String> startContractColumn;
    @FXML
    private TableColumn<Contract, String> endContractColumn;
    @FXML
    private TableColumn<Contract, String> resolutionContractColumn;
    @FXML
    private TableColumn<Contract, String> descriptionContractColumn;
    @FXML
    private JFXButton guardarButton;
    @FXML
    private JFXButton cancelarButton;
    private static ContractService service;
    private static PackageService packageService;
    private int id;

    public AddPaquetes() {
        service = ServicesLocator.getContractQ();
        packageService = ServicesLocator.getPackageService();
    }

    public void setCostoViajeHotelAeropuertoField(String value) {
        costoViajeHotelAeropuertoField.setText(value);
    }

    public void setNombrePromocionalField(String value) {
        nombrePromocionalField.setText(value);
    }

    public void setCantidadDiasField(String value) {
        cantidadDiasField.setText(value);
    }

    public void setCantidadNochesField(String value) {
        cantidadNochesField.setText(value);
    }

    public void setCantidadPersonasField(String value) {
        cantidadPersonasField.setText(value);
    }

    public void setPorcentajeGananciaField(String value) {
        porcentajeGananciaField.setText(value);
    }


    @FXML
    public void guardarButtonClicked(MouseEvent event) throws SQLException {
        String name = nombrePromocionalField.getText();
        int days = Integer.parseInt(cantidadDiasField.getText());
        int nights = Integer.parseInt(cantidadNochesField.getText());
        int pax = Integer.parseInt(cantidadPersonasField.getText());
        double cost = Double.parseDouble(costoViajeHotelAeropuertoField.getText());
        double percent = Double.parseDouble(porcentajeGananciaField.getText());
        Package p = new Package(name, days, nights, pax, cost, percent);
        if(packageService.find(p)){
            packageService.update_package(p);
        }else{
            Package pa = new Package(id,name, days, nights, pax, cost, percent);
            packageService.add_package(p);
        }

    }

    @FXML
    public void cancelarButtonClicked() {
        // Maneja el evento de clic del botón Cancelar aquí
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    //Update table
    public void updateContractsTable() throws SQLException {
        LinkedList<Contract> list = service.getContracts();
        ObservableList<Contract> listaVisible = FXCollections.observableArrayList(list);
        contractsTable.setItems(listaVisible);
    }

    public void setId(int id_package) {
        this.id = id_package;
    }
}
