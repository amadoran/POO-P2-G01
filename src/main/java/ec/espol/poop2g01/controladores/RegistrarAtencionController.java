package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class RegistrarAtencionController {

    @FXML
    private AnchorPane anchorPane;

    public void RealizarActividad() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("actividad.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Actividad Izquierda/Derecha");
        stage.setScene(scene);
        stage.show();
    }
}
