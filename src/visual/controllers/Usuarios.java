package visual.controllers;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Usuarios implements Initializable {
    //Table
    @FXML
    private TableColumn<Usuarios, String> user_name;
    @FXML
    private TableColumn<Usuarios, String> password;
    @FXML
    private TableColumn<Usuarios, String> role;
    @FXML
    private TableView<User> usersTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert user


    //Update user


    //Delete user
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteUser(select);
    }

    @FXML
    void deleteUser(ActionEvent select) {
        int pos = usersTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateUsersTable();
        }

    }

    //Update table
    public void updateUsersTable(){
        // Coding
    }

}
