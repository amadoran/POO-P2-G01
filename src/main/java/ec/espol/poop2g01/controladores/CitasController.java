package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CitasController {

    @FXML
    private AnchorPane anchorPane;

    public void IrACrearCitas() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("crearCitas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Creacion de Citas");
        stage.setScene(scene);
        stage.show();
    }

    public void IrARegistrarAtencion() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("registrarAtencion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Registro de Atención");
        stage.setScene(scene);
        stage.show();
    }

    public void IrAActividadesRealizadas() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("actividades.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Actividades Realizadas");
        stage.setScene(scene);
        stage.show();
    }
}
