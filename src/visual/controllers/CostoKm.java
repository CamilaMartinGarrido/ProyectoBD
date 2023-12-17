package visual.controllers;
import dto.Km_Cost;
import dto.Route;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class CostoKm implements Initializable {
    //Table
    @FXML
    private TableColumn<CostoKm, String> description_tm;
    @FXML
    private TableColumn<CostoKm, Double> km_cost;
    @FXML
    private TableColumn<CostoKm, Double> full_ride_km_cost;
    @FXML
    private TableColumn<CostoKm, Double> waiting_hours_cost;

    @FXML
    private TableView<Km_Cost> KmTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert meal_plan


    //Update meal_plan


    //Delete meal_plan
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteKm(select);
    }

    @FXML
    void deleteKm(ActionEvent select) {
        int pos = KmTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateKmTable();
        }

    }

    //Update table
    public void updateKmTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchRoutes(javafx.scene.input.KeyEvent event) {
    }
}
