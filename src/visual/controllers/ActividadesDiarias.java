package visual.controllers;

import dto.Daily_Activity;
import dto.User;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import services.Control;
import services.DailyActivityService;
import services.ServicesLocator;
import services.VehicleService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ActividadesDiarias implements Initializable {
    public GridPane btnsCRUD;
    //Table

    @FXML
    private TableColumn<ActividadesDiarias, String> day_activity;
    @FXML
    private TableColumn<ActividadesDiarias, Time> time_activity;
    @FXML
    private TableColumn<ActividadesDiarias, Double> cost_activity;
    @FXML
    private TableColumn<ActividadesDiarias,String>type_activity;
    @FXML
    private TableColumn<ActividadesDiarias,String>province_activity;
    @FXML
    private TableColumn<ActividadesDiarias, String> description_activity;

    @FXML
    private TableView<Daily_Activity> activitiesTable;
    private DailyActivityService service;

    public ActividadesDiarias() {
        activitiesTable = new TableView<>();
        service = ServicesLocator.getDailyActivityService();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        type_activity.setCellValueFactory(new PropertyValueFactory<>("type_activity"));
        day_activity.setCellValueFactory(new PropertyValueFactory<>("day_activity"));
        time_activity.setCellValueFactory(new PropertyValueFactory<>("time_activity"));
        cost_activity.setCellValueFactory(new PropertyValueFactory<>("cost_activity"));
        province_activity.setCellValueFactory(new PropertyValueFactory<>("province_activity"));
        description_activity.setCellValueFactory(new PropertyValueFactory<>("description_activity"));
        try {
            updateActivitiesTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        permisosRoles();
    }
    public void permisosRoles(){
        User u = Control.getInstance().getSessionUser();
        if(u.getId_role() == 1){
            btnsCRUD.setVisible(true);
        } else if(u.getId_role() == 2 || u.getId_role() == 3){
            btnsCRUD.setVisible(false);
        }
    }

    //Insert activity

    @FXML
    public void addClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Stage window = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogActiviadesDiarias.fxml"));

        window.setScene(new Scene(loader.load()));

        window.show();
    }
    //Update activity
   public void editClicked(MouseEvent mouseEvent) throws IOException, SQLException {
        int pos = activitiesTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Daily_Activity d = activitiesTable.getItems().get(pos);
            Stage window = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogActiviadesDiarias.fxml"));
            window.setScene(new Scene(loader.load()));
            DialogActiviadesDiarias controller = loader.getController();
            controller.setId(d.getId_activity());
            controller.setDiaActividad(d.getDay_activity());
            controller.setTipoActividad(d.getType_activity());
            controller.setCostoActividad(Double.toString(d.getCost_activity()));
            controller.setProvincia(d.getProvince_activity());
            controller.setRecargo(Double.toString(d.getSurcharge_activity()));
            controller.setDescripcionActividad(d.getDescription_activity());
            controller.setTiempo(String.valueOf(d.getTime_activity()));

            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un campo");
        }
    }

    //Delete activity
    @FXML
    private void deleteImageClicked(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteActivity(select);
    }

    @FXML
    void deleteActivity(ActionEvent select) throws SQLException {
        int pos = activitiesTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Daily_Activity d = activitiesTable.getItems().get(pos);
            activitiesTable.getItems().remove(pos);
            service.delete_daily_activity(d);
                  updateActivitiesTable();
        }

    }

    //Update table
    public void updateActivitiesTable() throws SQLException {
        LinkedList<Daily_Activity> list = DailyActivityService.getActivities();

        ObservableList<Daily_Activity> listaVisible = FXCollections.observableArrayList(list);

        activitiesTable.setItems(listaVisible);
    }

    //Search
    @FXML
    private void searchActivities(javafx.scene.input.KeyEvent event) {
    }

    public TableView<Daily_Activity> getActivitiesTable() {
        return activitiesTable;
    }
}
