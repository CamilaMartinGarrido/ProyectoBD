package visual.controllers;
import dto.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.HotelService;
import services.ServicesLocator;

import java.net.URL;
import java.sql.SQLException;
import java.util.LinkedList;
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
    private static HotelService service;

    public Hoteles(){
        hotelsTable = new TableView<>();
        service = ServicesLocator.getHotelQ();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_hotel.setCellValueFactory(new PropertyValueFactory<>("name_hotel"));
        chain_hotel.setCellValueFactory(new PropertyValueFactory<>("chain_hotel"));
        category_hotel.setCellValueFactory(new PropertyValueFactory<>("category_hotel"));
        address_hotel.setCellValueFactory(new PropertyValueFactory<>("address_hotel"));
        province_hotel.setCellValueFactory(new PropertyValueFactory<>("province_hotel"));
        try{
            updateHotelsTable();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    //Insert hotel


    //Update hotel


    //Delete hotel
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteHotel(select);
    }

    @FXML
    void deleteHotel(ActionEvent select) throws SQLException {
        int pos = hotelsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateHotelsTable();
        }

    }

    //Update table
    public void updateHotelsTable() throws SQLException {
        LinkedList<Hotel> list = HotelService.getHotels();
        ObservableList<Hotel> visibleList = FXCollections.observableArrayList(list);
        hotelsTable.setItems(visibleList);
    }

    //Search
    @FXML
    private void searchHotels(javafx.scene.input.KeyEvent event) {
    }
}
