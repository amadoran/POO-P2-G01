package ec.espol.poop2g1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modelo.Atencion;
import modelo.Cita;
import modelo.Cliente;
import modelo.Representante;

import javax.swing.*;
import java.awt.event.*;
public class MenuController {
    @FXML
    private AnchorPane scene;
    @FXML
    private Button servicios;
    @FXML
    private Button empleados;
    @FXML
    private Button atenciones;
    @FXML
    private Button citas;
    @FXML
    private Button clientes;
    @FXML
    private Button salirBtn;

    public void salir() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText("Va a salir del programa.");
        alert.setContentText("Click \"OK\" para confirmar.");
        if (alert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) scene.getScene().getWindow();
            stage.close();
        }
    }

}


