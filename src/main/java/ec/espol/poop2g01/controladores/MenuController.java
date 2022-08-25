package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
    @FXML
    private AnchorPane anchorPane;
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

    public void salir(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText("Va a salir del programa.");
        alert.setContentText("Click \"OK\" para confirmar.");
        if (alert.showAndWait().get() == ButtonType.OK){
            Stage stage = (Stage) anchorPane.getScene().getWindow();
            stage.close();
        }
    }

    public void cambiarAServicios() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("servicios-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }

    public void cambiarAEmpleados() throws IOException{
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("empleados.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Empleados");
        stage.setScene(scene);
        stage.show();
    }
  }
