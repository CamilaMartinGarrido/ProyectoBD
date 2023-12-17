package visual.controllers;
import dto.User;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import services.ServicesLocator;
import services.UserService;

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
    @FXML
    private MFXTextField textBuscar;

    private final UserService us = ServicesLocator.getUserService();
    private ObservableList<User> usuarios = FXCollections.observableArrayList();
    private final FilteredList<User> filtroUsuarios = new FilteredList<>(usuarios, b -> true);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    //Insert user


    //Update user


    //Delete user
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException, ClassNotFoundException {
        int pos = usersTable.getSelectionModel().getSelectedIndex();
        deleteUser(pos);
    }

    @FXML
    void deleteUser(int pos) throws SQLException, ClassNotFoundException {
        if(pos != -1){
           // UserService.eliminarUsuario(UserService.getUsers().get(pos).getId_user());
            updateUsersTable();
        }

    }

    //Update table
    public void updateUsersTable() throws SQLException, ClassNotFoundException {
        usuarios = FXCollections.observableArrayList(UserService.getUsers());
        usersTable.setItems(usuarios);
    }

    //Search
    @FXML
    private void searchUsers(javafx.scene.input.KeyEvent event) {
        setupFilter(textBuscar, usersTable, filtroUsuarios);
    }

    public void setupFilter(MFXTextField textBuscar, TableView<User> usersTable, FilteredList<User> filtroUsuarios) {
        textBuscar.textProperty().addListener((observable, oldValue, newValue) -> {
            filtroUsuarios.setPredicate(user -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();
                if (user.getUser_name().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (String.valueOf(user.getId_role()).contains(lowerCaseFilter)) {
                    return true;
                } else {
                    return false;
                }
            });
        });
        SortedList<User> datosOrdenados = new SortedList<>(filtroUsuarios);
        datosOrdenados.comparatorProperty().bind(usersTable.comparatorProperty());
        usersTable.setItems(datosOrdenados);
    }
}