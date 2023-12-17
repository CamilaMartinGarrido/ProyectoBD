package visual.controllers;
import dto.Rol;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Roles implements Initializable {
    //Table
    @FXML
    private TableColumn<Roles, String> name_role;
    @FXML
    private TableColumn<Roles, String> description_role;
    @FXML
    private TableView<Rol> rolesTable;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert role


    //Update role


    //Delete role
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteRole(select);
    }

    @FXML
    void deleteRole(ActionEvent select) {
        int pos = rolesTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateRolesTable();
        }

    }

    //Update table
    public void updateRolesTable(){
        // Coding
    }

}
