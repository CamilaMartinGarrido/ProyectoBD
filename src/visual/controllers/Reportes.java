package visual.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import services.ReportService;

public class Reportes {

    @FXML
    private JFXButton btnReporte1;

    @FXML
    private JFXButton btnReporte2;

    @FXML
    private JFXButton btnReporte3;

    @FXML
    private JFXButton btnReporte4;

    @FXML
    private JFXButton btnReporte5;

    @FXML
    private JFXButton btnReporte6;

    @FXML
    private JFXButton btnReporte7;

    @FXML
    private JFXButton btnReporte8;

    @FXML
    private AnchorPane pnReportes;

    @FXML
    void contratosHoteles(ActionEvent event) {
        ReportService.reports.loadReport1();
    }

    @FXML
    void contratosServicios(ActionEvent event) {
        ReportService.reports.loadReport4();
    }

    @FXML
    void contratosTemmporadasHoteles(ActionEvent event) {
        ReportService.reports.loadReport2();
    }

    @FXML
    void contratosTransporte(ActionEvent event) {
        ReportService.reports.loadReport3();
    }

    @FXML
    void hotelesActivos(ActionEvent event) {
        ReportService.reports.loadReport5(null, null);
    }

    @FXML
    void hotelesInactivos(ActionEvent event) {
        ReportService.reports.loadReport8();
    }

    @FXML
    void planIngreso(ActionEvent event) {
        ReportService.reports.loadReport7();
    }

    @FXML
    void proramaPaquete(ActionEvent event) {
        ReportService.reports.loadReport6();
    }

}
