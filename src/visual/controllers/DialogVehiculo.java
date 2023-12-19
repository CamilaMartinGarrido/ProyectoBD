package visual.controllers;

import com.jfoenix.controls.JFXButton;
import dto.Vehicle;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import services.ServicesLocator;
import services.VehicleService;
import utiles.Validaciones;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DialogVehiculo implements Initializable {
    @FXML
    private MFXTextField matricula;

    @FXML
    private MFXTextField marca;

    @FXML
    private MFXTextField capacidadEquipaje;

    @FXML
    private MFXTextField capacidadSinEquipaje;

    @FXML
    private MFXTextField anno;

    @FXML
    private MFXTextField capacidadTotal;

    @FXML
    private Label titulo;

    @FXML
    private JFXButton guardar;

    @FXML
    private JFXButton cancelar;


    @FXML
    private AnchorPane root;
    private final Vehiculos v = new Vehiculos();
    private final VehicleService service;
    private int id;
    private StringBuilder errors;

    public DialogVehiculo() {
        service = ServicesLocator.getVehicleService();
    }


    @FXML
    private void cancelarClicked() {
        // Lógica del botón Cancelar
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    public void setId(int value) {
        id = value;
    }

    public void setMatricula(String value) {
        matricula.setText(value);
    }

    public void setMarca(String value) {
        marca.setText(value);
    }

    public void setCapacidadEquipaje(String value) {
        capacidadEquipaje.setText(value);
    }

    public void setCapacidadSinEquipaje(String value) {
        capacidadSinEquipaje.setText(value);
    }

    public void setAnno(String value) {
        anno.setText(value);
    }

    public void setCapacidadTotal(String value) {
        capacidadTotal.setText(value);
    }

    @FXML
    public void guardarClicked(javafx.scene.input.MouseEvent mouseEvent) throws SQLException {
        if(Validaciones.validarLetras(matricula.getText(), "Matricula", errors)
        || Validaciones.validarLetras(marca.getText(), "Marca", errors)
        || Validaciones.validarNumeros(capacidadEquipaje.getText(), "Capacidad de Equipaje", errors)
        || Validaciones.validarNumeros(capacidadSinEquipaje.getText(), "Capacidad sin Equipaje", errors)
        || Validaciones.validarNumeros(capacidadTotal.getText(), "Capacidad Total", errors)
        || Validaciones.validarNumeros(anno.getText(), "Año", errors)) {
        String plate = matricula.getText();
        String brand = marca.getText();
        double luggageCapacity = Double.parseDouble(capacidadEquipaje.getText());
        double totalCapacity = Double.parseDouble(capacidadTotal.getText());
        double whithLuggage = Double.parseDouble(capacidadSinEquipaje.getText());
        int year = Integer.parseInt(anno.getText());

          Vehicle vehicle = new Vehicle(id, plate, brand, luggageCapacity, whithLuggage, totalCapacity, year);
          if (service.findVehicle(vehicle)) {
              service.update_vehicle(vehicle);
          } else {
              Vehicle aux = new Vehicle(plate, brand, luggageCapacity, whithLuggage, totalCapacity, year);
              TableView<Vehicle> t = v.getTable();
              t.getItems().add(aux);
              service.add_vehicle(aux);
          }
      } else {
          JOptionPane.showMessageDialog(null,"Tiene los siguientes errores" +errors);
      }
            v.getTable().refresh();
        }

    public static boolean validarLetras(String valor, String nombreObject, StringBuilder errors) {
        boolean a = false;
        if (validarCampoVacio(valor,nombreObject, errors)) {
            a = true;
        } else if (!valor.matches("[a-zA-Z]*")) {
            errors.append("El campo ").append(nombreObject).append(" solo permite letras \n");
            a = true;
        }
        return a;
    }
    public static boolean validarNumeros(String valor, String nombreObject, StringBuilder errors) {
        boolean a = true;
        if (validarCampoVacio(valor,nombreObject, errors)) {
            a = false;
        } else if (!valor.matches("\\d*")) {
            errors.append("El campo ").append(nombreObject).append(" solo permite letras\n");
            a = false;
        }
        return a;
    }
    public static boolean validarCampoVacio(String valor, String nombreObject, StringBuilder errors) {
        boolean a = false;
        if (valor.isEmpty()) {
            errors.append("El campo ").append(nombreObject).append(" está vacío\n");
            a = true;
        }
        return a;
    }

}



