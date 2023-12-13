package visual.controllers;
import dto.Meal_Plan;
import dto.Vehicle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.ResourceBundle;

public class PlanesAlimenticios implements Initializable {
    //Table
    @FXML
    private TableColumn<PlanesAlimenticios, String> plan_type;
    @FXML
    private TableColumn<PlanesAlimenticios, Double> plan_cost;
    @FXML
    private TableView<Meal_Plan> plansTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

    //Insert meal_plan


    //Update meal_plan


    //Delete meal_plan
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteVehicle(select);
    }

    @FXML
    void deleteVehicle(ActionEvent select) {
        int pos = plansTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updatePlansTable();
        }

    }

    //Update table
    public void updatePlansTable(){
        // Coding
    }

}
