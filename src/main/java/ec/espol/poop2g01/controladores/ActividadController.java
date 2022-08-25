package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ActividadController {
    @FXML
    private VBox principal;
    @FXML
    private ComboBox<Integer> cmbCantidad;
    @FXML
    private HBox hboxAbajo;

    @FXML
    public void initialize(){
        cmbCantidad.getItems().setAll(3,4,5,6,7,8,9,10);
    }

    public void mostrarSiguiente(){
        ImageView imageView = new ImageView();
        Image image = new Image(Aplicacion.class.getResourceAsStream("imagenes/arrow_right.png"), 150, 104, false, false);
        imageView.setImage(image);
        imageView.setOnMouseClicked(mouseEvent -> {
            Stage stage = (Stage) principal.getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("juego.fxml"));
            try {
                Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                stage.setTitle("Juego");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        hboxAbajo.getChildren().clear();
        hboxAbajo.getChildren().add(imageView);
    }
}
