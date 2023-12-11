package visual.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private ImageView btnClose;

    @FXML
    private MFXButton btnLogin;

    @FXML
    private ImageView loginBack;

    @FXML
    private MFXPasswordField textPassword;

    @FXML
    private MFXTextField textUser;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void closeWindow(javafx.scene.input.MouseEvent mouseEvent) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public void accederSistema(ActionEvent event){
        String username = textUser.getText();
        String password = textPassword.getText();
        String rol = null;
        //if para comparar el usuario y la contraseña con la base de datos
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visual/views/Hotel.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Ventana");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
