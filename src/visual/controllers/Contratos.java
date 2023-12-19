package visual.controllers;

import dto.Contract;
import dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import services.ContractService;
import services.Control;
import services.ServicesLocator;

import java.net.URL;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class Contratos implements Initializable {
    public GridPane btnsCRUD;
    //Tabla De Contratos

    @FXML
    private TableColumn<Contratos, Date> start_contract;
    @FXML
    private TableColumn<Contratos, Date> end_contract;
    @FXML
    private TableColumn<Contratos, Date> resolution_contract;
    @FXML
    private TableColumn<Contratos, String> description_contract;
    @FXML
    private TableColumn<Contratos, String> contract_type;
    @FXML
    private TableView<Contract> contractsTable;

    private static ContractService service;

    public Contratos() {
        contractsTable = new TableView<>();
        service = ServicesLocator.getContractQ();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contract_type.setCellValueFactory(new PropertyValueFactory<>("contract_type"));
        start_contract.setCellValueFactory(new PropertyValueFactory<>("start_contract"));
        end_contract.setCellValueFactory(new PropertyValueFactory<>("end_contract"));
        resolution_contract.setCellValueFactory(new PropertyValueFactory<>("resolution_contract"));
        description_contract.setCellValueFactory(new PropertyValueFactory<>("description_contract"));
        try {
            updateContractsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        permisosRoles();
    }
    public void permisosRoles(){
        User u = Control.getInstance().getSessionUser();
        if(u.getId_role() == 1 || u.getId_role() == 3){
            btnsCRUD.setVisible(true);
        } else if(u.getId_role() == 2){
            btnsCRUD.setVisible(false);
        }
    }
    //Insert contract


    //Update contract


    //Delete contract
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteContract(select);
    }

    @FXML
    void deleteContract(ActionEvent select) throws SQLException {
        int pos = contractsTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            //
            updateContractsTable();
        }

    }

    //Update table
    public void updateContractsTable() throws SQLException {
        LinkedList<Contract> list = service.getContracts();
        ObservableList<Contract> listaVisible = FXCollections.observableArrayList(list);
        contractsTable.setItems(listaVisible);
    }

    public void searchContracts(KeyEvent keyEvent) {
    }

    //Search
}
