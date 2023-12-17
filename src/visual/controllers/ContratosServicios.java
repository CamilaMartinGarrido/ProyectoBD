package visual.controllers;
import dto.Contract_Service;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ContratosServicios implements Initializable {
    //Table
    @FXML
    private TableColumn<ContratosServicios, String> type_activity;
    @FXML
    private TableColumn<ContratosServicios, Date> start_contract;
    @FXML
    private TableColumn<ContratosServicios, Date> end_contract;
    @FXML
    private TableColumn<ContratosServicios, Date> resolution_contract;
    @FXML
    private TableColumn<ContratosServicios, String> description_contract;
    @FXML
    private TableView<Contract_Service> contractsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert contract


    //Update contract


    //Delete contract
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteContract(select);
    }

    @FXML
    void deleteContract(ActionEvent select) {
        int pos = contractsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateContractsTable();
        }

    }

    //Update table
    public void updateContractsTable(){
        // Coding
    }

    //Search
}
