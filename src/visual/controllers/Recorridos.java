package visual.controllers;
import dto.Route;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class Recorridos implements Initializable {
    //Table
    @FXML
    private TableColumn<Recorridos, String> description_tm;
    @FXML
    private TableColumn<Recorridos, String> description_route;
    @FXML
    private TableColumn<Recorridos, Double> route_cost;
    @FXML
    private TableColumn<Recorridos, Double> full_ride_cost;
    @FXML
    private TableView<Route> routesTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert meal_plan


    //Update meal_plan


    //Delete meal_plan
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deletePlan(select);
    }

    @FXML
    void deletePlan(ActionEvent select) {
        int pos = routesTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateRoutesTable();
        }

    }

    //Update table
    public void updateRoutesTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchRoutes(javafx.scene.input.KeyEvent event) {
    }
}
