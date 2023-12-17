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

    //Update table
    public void updateRolesTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchRoles(javafx.scene.input.KeyEvent event) {
    }
}
