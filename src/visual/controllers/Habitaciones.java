package visual.controllers;
import dto.Room;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Habitaciones implements Initializable {
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
    public void initialize(URL url, ResourceBundle resourceBundle) { }

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
