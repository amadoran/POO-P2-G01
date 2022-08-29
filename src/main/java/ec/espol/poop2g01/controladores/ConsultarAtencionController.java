package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ConsultarAtencionController {

    @FXML
    private AnchorPane anchorPane;

    public void regresarMenu() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }
}
