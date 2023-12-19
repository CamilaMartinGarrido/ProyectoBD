package visual.controllers;
import dto.season;
import dto.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import services.Control;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Temporadas implements Initializable {
    public GridPane btnsCRUD;
    //Table
    @FXML
    private TableColumn<Temporadas, String> name_season;
    @FXML
    private TableColumn<Temporadas, Date> start_season;
    @FXML
    private TableColumn<Temporadas, Date> end_season;
    @FXML
    private TableColumn<Temporadas, String> description_season;
    @FXML
    private TableView<season> seasonsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {permisosRoles(); }
    public void permisosRoles(){
        User u = Control.getInstance().getSessionUser();
        if(u.getId_role() == 1){
            btnsCRUD.setVisible(true);
        } else if(u.getId_role() == 2 || u.getId_role() == 3){
            btnsCRUD.setVisible(false);
        }
    }

    //Insert season


    //Update season


    //Delete season
    @FXML
    private void deleteImageClicked(ActionEvent event) {
        ActionEvent select = new ActionEvent();
        deleteSeason(select);
    }

    @FXML
    void deleteSeason(ActionEvent select) {
        int pos = seasonsTable.getSelectionModel().getSelectedIndex();
        if(pos != -1){
            //
            updateSeasonsTable();
        }

    }

    //Update table
    public void updateSeasonsTable(){
        // Coding
    }

    //Search
    @FXML
    private void searchSeasons(javafx.scene.input.KeyEvent event) {
    }
}
