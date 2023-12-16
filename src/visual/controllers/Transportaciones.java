package visual.controllers;
import dto.Transportation_Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Transportaciones implements Initializable {
    //Table
    @FXML
    private TableColumn<Transportaciones, String> user_name;
    @FXML
    private TableColumn<Transportaciones, String> password;
    @FXML
    private TableColumn<Transportaciones, String> role;
    @FXML
    private TableView<Transportation_Model> transportationsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert user


    //Update user


    //Delete user
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        ActionEvent select = new ActionEvent();
        deleteTransportation(select);
    }

    @FXML
    void deleteTransportation(ActionEvent select) throws SQLException, ClassNotFoundException {
        int pos = transportationsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateTransportationsTable();
        }

    }

    //Update table
    public void updateTransportationsTable() throws SQLException, ClassNotFoundException {
        //
    }

    //Search
    @FXML
    private void searchTransportations(javafx.scene.input.KeyEvent event) {
    }
}
