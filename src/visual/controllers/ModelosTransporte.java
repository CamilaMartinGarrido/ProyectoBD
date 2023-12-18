package visual.controllers;
import dto.Transportation_Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ModelosTransporte implements Initializable {
    //Tabla De Contratos
    @FXML
    private TableColumn<ModelosTransporte, String> type_transp_model;
    @FXML
    private TableColumn<ModelosTransporte, String> description_tm;
    @FXML
    private TableView<Transportation_Model> modelsTable;

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
        int pos = modelsTable.getSelectionModel().getSelectedIndex();
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

