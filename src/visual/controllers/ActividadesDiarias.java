package visual.controllers;

import dto.Daily_Activity;
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
import services.DailyActivityService;
import services.ServicesLocator;
import services.VehicleService;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ActividadesDiarias implements Initializable {
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

    }

    //Insert activity

    @FXML
    public void addClicked(javafx.scene.input.MouseEvent mouseEvent) throws IOException {
        Stage window = new Stage();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogActividadesDiarias.fxml"));

        window.setScene(new Scene(loader.load()));

        window.show();
    }
    //Update activity
    public void editClicked(MouseEvent mouseEvent) throws IOException, SQLException {
        int pos = activitiesTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Daily_Activity d = activitiesTable.getItems().get(pos);
            Stage window = new Stage();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/visual/views/dialogs/DialogVehiculo.fxml"));
            window.setScene(new Scene(loader.load()));
            DialogActiviadesDiarias controller = loader.getController();
            controller.setId(d.getId_activity());
            controller.setMatricula(d.getProvince_activity());
            controller.setMarca(v.getBrand());
            controller.setAnno(String.valueOf(v.getYear_build()));
            controller.setCapacidadEquipaje(String.valueOf(v.getLuggage_capacity()));
            controller.setCapacidadSinEquipaje(String.valueOf(v.getWith_luggage_capacity()));
            controller.setCapacidadTotal(String.valueOf(v.getTotal_capacity()));

            window.show();
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione un campo");
        }
    }

    //Delete activity
    @FXML
    private void deleteImageClicked(ActionEvent event) throws SQLException {
        ActionEvent select = new ActionEvent();
        deleteActivity(select);
    }

    @FXML
    void deleteActivity(ActionEvent select) throws SQLException {
        int pos = activitiesTable.getSelectionModel().getSelectedIndex();
        if (pos != -1) {
            Daily_Activity d = activitiesTable.getItems().get(pos);
            activitiesTable.getItems().remove(pos);
            service.delete_daily_activity();
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
}
