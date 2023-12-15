package visual.controllers;
import dto.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.ServicesLocator;
import java.net.URL;
import java.sql.SQLException;
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

    private ObservableList<User> usuarios;
    private ObservableList<User> filtroUsuarios;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usuarios = FXCollections.observableArrayList();
        filtroUsuarios = FXCollections.observableArrayList();
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
        int pos = usersTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            ServicesLocator.getUserService().eliminarUsuario(ServicesLocator.getUserService().getUsers().get(pos).getId_user());
            updateUsersTable();
        }

    }

    //Update table
    public void updateUsersTable() throws SQLException, ClassNotFoundException {
        usuarios = FXCollections.observableArrayList(ServicesLocator.getUserService().getUsers());
        usersTable.setItems(usuarios);
    }

}