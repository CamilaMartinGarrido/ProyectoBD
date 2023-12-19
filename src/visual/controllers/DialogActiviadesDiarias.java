package visual.controllers;

import com.jfoenix.controls.JFXButton;
import dto.Daily_Activity;
import dto.Vehicle;
import io.github.palexdev.materialfx.controls.MFXDatePicker;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import services.DailyActivityService;
import services.ServicesLocator;

import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;

public class DialogActiviadesDiarias implements Initializable {

    @FXML
    private MFXTextField tipoActividad;

    @FXML
    private MFXTextField costoActividad;

    @FXML
    private Label titulo;

    @FXML
    private JFXButton guardar;

    @FXML
    private JFXButton cancelar;

    @FXML
    private MFXTextField provincia;

    @FXML
    private MFXTextField tiempo;

    @FXML
    private MFXTextField recargo;

    @FXML
    private MFXDatePicker diaActividad;
    @FXML
    private MFXTextField descripcionActividad;
private int id;
private ActividadesDiarias d = new ActividadesDiarias();
private DailyActivityService service;
public DialogActiviadesDiarias(){
    service = ServicesLocator.getDailyActivityService();
}

    public void setId(int value){
        id = value;
    }

    public void setTipoActividad(String value) {
        tipoActividad.setText(value);
    }

    public void setCostoActividad(String value) {
        this.costoActividad.setText(value);
    }

    public void setTitulo(Label titulo) {
        this.titulo = titulo;
    }

    public void setGuardar(JFXButton guardar) {
        this.guardar = guardar;
    }

    public void setCancelar(JFXButton cancelar) {
        this.cancelar = cancelar;
    }

    public void setProvincia(String value) {
        this.provincia.setText(value);
    }

    public void setTiempo(String value) {
        this.tiempo.setText(value);
    }

    public void setRecargo(String value) {
        this.recargo.setText(value);
    }

    public void setDiaActividad(String value) {
        this.diaActividad.setText(value);
    }

    public void setDescripcionActividad(String value) {
        this.descripcionActividad.setText(value);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void guardarClicked(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        String tipo = tipoActividad.getText();
        String dia = diaActividad.getText();
        Timestamp t = Timestamp.valueOf(tiempo.getText());
       Double cost = Double.parseDouble(costoActividad.getText());
       String province = provincia.getText();
       String desc = descripcionActividad.getText();
       Double surcharge = Double.parseDouble(recargo.getText());

        Daily_Activity daily_activity = new Daily_Activity(id,tipo,dia,t,cost,province,desc,surcharge);
        if (service.findActivity(daily_activity) == true) {
            service.update_daily_activity(daily_activity);
        } else {
            Daily_Activity aux = new Daily_Activity(tipo,dia,t,cost,province,desc,surcharge);
            TableView<Daily_Activity> a = d.getActivitiesTable();
            a.getItems().add(aux);
            service.add_daily_activity(aux);
        }



    }
}
