package visual.controllers;
import dto.Daily_Activity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.sql.Time;
import java.util.ResourceBundle;

public class ActividadesDiarias implements Initializable {
    //Table
    @FXML
    private TableColumn<ActividadesDiarias, String> type_activity;
    @FXML
    private TableColumn<ActividadesDiarias, String> day_activity;
    @FXML
    private TableColumn<ActividadesDiarias, Time> time_activity;
    @FXML
    private TableColumn<ActividadesDiarias, Double> cost_activity;
    @FXML
    private TableColumn<ActividadesDiarias, String> province_activity;
    @FXML
    private TableColumn<ActividadesDiarias, String> description_activity;
    @FXML
    private TableColumn<ActividadesDiarias, Double> surcharge_activity;
    @FXML
    private TableView<Daily_Activity> activitiesTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert activity


    //Update activity


    //Delete activity
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteActivity(select);
    }

    @FXML
    void deleteActivity(ActionEvent select) {
        int pos = activitiesTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateActivitiesTable();
        }

    }

    //Update table
    public void updateActivitiesTable(){
        // Coding
    }

}
