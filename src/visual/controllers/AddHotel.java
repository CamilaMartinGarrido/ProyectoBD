package visual.controllers;

import dto.Hotel;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import services.Hotel_Service;
import services.ServicesLocator;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddHotel implements Initializable {
    @FXML
    private MFXTextField hotelNameField;
    @FXML
    private MFXTextField hotelChainField;
    @FXML
    private MFXTextField addressField;
    @FXML
    private MFXTextField categoryField;
    @FXML
    private MFXTextField provinceField;
    private int id;
    private Hotel_Service service;

    public AddHotel() {
        service = ServicesLocator.getHotelQ();
    }

    public void setId(int value) {
        id = value;
    }

    public void setHotelName(String hotelName) {
        hotelNameField.setText(hotelName);
    }

    public void setHotelChain(String hotelChain) {
        hotelChainField.setText(hotelChain);
    }

    public void setAddress(String address) {
        addressField.setText(address);
    }

    public void setCategory(String category) {
        categoryField.setText(category);
    }

    public void setProvince(String province) {
        provinceField.setText(province);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void guardarButon(MouseEvent mouseEvent) throws SQLException {
        String name = this.hotelNameField.getText();
        String chain = this.hotelChainField.getText();
        String adress = this.addressField.getText();
        String category = this.categoryField.getText();
        String province = this.provinceField.getText();
        Hotel hotel = new Hotel(id, name, chain, category, adress, province);
        if (service.find(hotel)) {
            service.update_Hotel(hotel);
        } else {
            Hotel h2 = new Hotel(id, name, chain, category, adress, province);
            service.add_Hotel(h2);
        }
    }
}
