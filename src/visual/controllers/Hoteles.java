package visual.controllers;

import dto.Hotel;
import dto.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import services.HotelService;
import services.ServicesLocator;

import javax.swing.*;
import java.io.IOException;
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

    public Hoteles() {

        service = ServicesLocator.getHotelQ();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name_hotel.setCellValueFactory(new PropertyValueFactory<>("name_hotel"));
        chain_hotel.setCellValueFactory(new PropertyValueFactory<>("chain_hotel"));
        category_hotel.setCellValueFactory(new PropertyValueFactory<>("category_hotel"));
        address_hotel.setCellValueFactory(new PropertyValueFactory<>("address_hotel"));
        province_hotel.setCellValueFactory(new PropertyValueFactory<>("province_hotel"));
        try {
            updateHotelsTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Insert hotel


    //Update hotel


    //Delete hotel
    @FXML
    public void deleteImageClicked(MouseEvent mouseEvent) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteHotel(select);
    }

    private void deleteHotel(ActionEvent select) throws SQLException {
        int pos = hotelsTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Hotel h = hotelsTable.getItems().get(pos);
            hotelsTable.getItems().remove(pos);
            service.delete_Hotel(h);
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


    public void addClicked(MouseEvent mouseEvent) throws IOException {
        Stage window = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogHotel.fxml"));
        window.setScene(new Scene(loader.load()));
        window.show();
    }

    public void editClickd(MouseEvent mouseEvent) throws IOException {
        int pos = hotelsTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Hotel h = hotelsTable.getItems().get(pos);

            Stage window = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogHotel.fxml"));
            window.setScene(new Scene(loader.load()));
            AddHotel controller = loader.getController();
            controller.setId(h.getId_hotel());
            controller.setAddress(h.getAddress_hotel());
            controller.setProvince(h.getProvince_hotel());
            controller.setHotelChain(h.getChain_hotel());
            controller.setHotelName(h.getName_hotel());
            controller.setCategory(h.getCategory_hotel());

            window.show();
        }else {
            JOptionPane.showMessageDialog(null, "Seleccione un campo");
        }
    }
}
