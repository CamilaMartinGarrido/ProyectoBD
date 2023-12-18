package visual.controllers;

import dto.Daily_Activity;
import dto.Vehicle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import services.DailyActivityService;
import services.ServicesLocator;
import services.VehicleService;

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
        day_activity.setCellValueFactory(new PropertyValueFactory<>("day_activity"));
        time_activity.setCellValueFactory(new PropertyValueFactory<>("time_activity"));
        cost_activity.setCellValueFactory(new PropertyValueFactory<>("cost_activity"));
        description_activity.setCellValueFactory(new PropertyValueFactory<>("description_activity"));
        try {
            updateActivitiesTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //Insert activity


    //Update activity


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
            //
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
