package visual.controllers;
import dto.Season;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class Temporadas implements Initializable {
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
    private TableView<Season> seasonsTable;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) { }

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
