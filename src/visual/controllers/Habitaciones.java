package visual.controllers;
import dto.Room;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import services.Control;

import java.net.URL;
import java.util.ResourceBundle;

public class Habitaciones implements Initializable {
    public GridPane btnsCRUD;
    //Table
    @FXML
    private TableColumn<Habitaciones, String> room_number;
    @FXML
    private TableColumn<Habitaciones, String> room_type;
    @FXML
    private TableColumn<Habitaciones, Double> room_cost;
    @FXML
    private TableColumn<Habitaciones, Double> room_surcharge;
    @FXML
    private TableColumn<Habitaciones, String> meal_plan;
    @FXML
    private TableView<Room> roomsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        permisosRoles();
    }
    public void permisosRoles(){
        User u = Control.getInstance().getSessionUser();
        if(u.getId_role() == 1){
            btnsCRUD.setVisible(true);
        } else if(u.getId_role() == 2 || u.getId_role() == 3){
            btnsCRUD.setVisible(false);
        }
    }

    //Insert room


    //Update room


    //Delete room
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteRoom(select);
    }

    @FXML
    void deleteRoom(ActionEvent select) {
        int pos = roomsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateRoomsTable();
        }

    }

    //Update table
    public void updateRoomsTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchRooms(javafx.scene.input.KeyEvent event) {
    }
}
