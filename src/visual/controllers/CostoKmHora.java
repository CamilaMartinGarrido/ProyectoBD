package visual.controllers;
import dto.Km_Hours_Cost;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class CostoKmHora implements Initializable {
    //Table
    @FXML
    private TableColumn<CostoKmHora, String> description_tm;
    @FXML
    private TableColumn<CostoKmHora, Double> route_km_cost;
    @FXML
    private TableColumn<CostoKmHora, Double> hours_cost;
    @FXML
    private TableColumn<CostoKmHora, Double> extra_km_cost;
    @FXML
    private TableColumn<CostoKmHora, Double> extras_hours_cost;
    @FXML
    private TableView<Km_Hours_Cost> KmHoursTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert meal_plan


    //Update meal_plan


    //Delete meal_plan
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteKmHours(select);
    }

    @FXML
    void deleteKmHours(ActionEvent select) {
        int pos = KmHoursTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateKmHoursTable();
        }

    }

    //Update table
    public void updateKmHoursTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchKmHours(javafx.scene.input.KeyEvent event) {
    }
}
