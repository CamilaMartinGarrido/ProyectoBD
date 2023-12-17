package visual.controllers;
import dto.Hotel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Hoteles implements Initializable {
    //Table
    @FXML
    private TableColumn<Hoteles, String> name_hotel;
    @FXML
    private TableColumn<Hoteles, String> chain_hotel;
    @FXML
    private TableColumn<Hoteles, String> category_hotel;
    @FXML
    private TableColumn<Hoteles, String> address_hotel;
    @FXML
    private TableColumn<Hoteles, String> province_hotel;
    @FXML
    private TableView<Hotel> hotelsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert hotel


    //Update hotel


    //Delete hotel
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteHotel(select);
    }

    @FXML
    void deleteHotel(ActionEvent select) {
        int pos = hotelsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateHotelsTable();
        }

    }

    //Update table
    public void updateHotelsTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchHotels(javafx.scene.input.KeyEvent event) {
    }
}
