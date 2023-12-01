package visual.controllers;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

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
}
