package visual.controllers;

import com.jfoenix.controls.JFXRippler;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

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
