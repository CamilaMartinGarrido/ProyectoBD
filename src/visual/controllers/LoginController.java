package visual.controllers;

import dto.User;
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
import javafx.stage.StageStyle;
import services.Control;
import services.UserService;

import javax.swing.*;
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

    private void close(){
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public void closeWindow(javafx.scene.input.MouseEvent mouseEvent) {
        close();
    }

    public void SystemAccess(ActionEvent event) {
        getIn();
    }

    private void getIn() {
        int rol = -1;
        rol = UserService.getLoginUser(textUser.getText(), textPassword.getText());
        if (rol == -1) {
            JOptionPane.showMessageDialog(null, "Contraseña y usuario inválidos");
            textPassword.setText("");
        } else {
            User user = new User(textUser.getText(), rol);
            Control.getInstance().setSessionUser(user);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/visual/views/Dashboard.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Ventana");
                stage.setScene(new Scene(root));
                stage.initStyle(StageStyle.UNDECORATED);
                stage.show();
                close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
