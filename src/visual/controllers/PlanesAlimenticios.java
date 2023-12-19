package visual.controllers;
import dto.MealPlan;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import services.Control;

import java.net.URL;
import java.util.ResourceBundle;

public class PlanesAlimenticios implements Initializable {
    public GridPane btnsCRUD;
    //Table
    @FXML
    private TableColumn<PlanesAlimenticios, String> plan_type;
    @FXML
    private TableColumn<PlanesAlimenticios, Double> plan_cost;
    @FXML
    private TableView<MealPlan> plansTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { permisosRoles(); }
    public void permisosRoles(){
        User u = Control.getInstance().getSessionUser();
        if(u.getId_role() == 1){
            btnsCRUD.setVisible(true);
        } else if(u.getId_role() == 2 || u.getId_role() == 3){
            btnsCRUD.setVisible(false);
        }
    }
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

    //Search
    @FXML
    private void searchPlans(javafx.scene.input.KeyEvent event) {
    }
}
