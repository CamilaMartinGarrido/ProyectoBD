package visual.controllers;
import com.jfoenix.controls.JFXButton;
import dto.User;
import io.github.palexdev.materialfx.controls.MFXComboBox;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import services.ServicesLocator;
import services.UserService;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddUser implements Initializable {

    @FXML
    private MFXTextField nombreUsuarioField;

    @FXML
    private MFXTextField contraseñaField;

    @FXML
    private MFXComboBox rolComboBox;

    @FXML
    private JFXButton guardarButton;

    @FXML
    private JFXButton cancelarButton;

    @FXML
    private Label tituloLabel;
    private int id;
private UserService service;
    public void setNombreUsuarioField(String value){
        this.nombreUsuarioField.setText(value);
    }
    public void setContraseñaField(String value){
        this.contraseñaField.setText(value);
    }

    public void setId(int value){
        id = value;
    }
    public AddUser(){
         service = ServicesLocator.getUserService();
    }

    @FXML
    private void guardarClicked(MouseEvent event) throws SQLException, ClassNotFoundException {
        String userName = nombreUsuarioField.getText();
        String pass = contraseñaField.getText();
        int rol = Integer.parseInt(rolComboBox.getText());
        User u = new User(userName,pass,rol);
        if(UserService.find(u) == true){

        }else{
            User user = new User(id,userName,pass,rol);
            UserService.addUser(user);
        }
    }

    @FXML
    private void cancelarButtonAction() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
