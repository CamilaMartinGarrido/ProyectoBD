package visual.controllers;
import dto.Contract_Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Contratos implements Initializable {
    //Tabla De Contratos
    @FXML
    private TableColumn<Contratos, String> name_hotel;
    @FXML
    private TableColumn<Contratos, Date> start_contract;
    @FXML
    private TableColumn<Contratos, Date> end_contract;
    @FXML
    private TableColumn<Contratos, Date> resolution_contract;
    @FXML
    private TableColumn<Contratos, String> description_contract;
    @FXML
    private TableView<Contract_Hotel> contractsTable;
    //Tabla de habitaciones del hotel
    @FXML
    private TableColumn<Contratos, String> type_room;
    @FXML
    private TableColumn<Contratos, Integer> room_number;
    //Tabla de temporadas
    @FXML
    private TableColumn<Contratos, String> name_season;

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
