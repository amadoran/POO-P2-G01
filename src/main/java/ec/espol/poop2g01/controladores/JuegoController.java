package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.layout.*;


import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;


public class JuegoController {
    @FXML
    private FlowPane contenedorPatos;

    private final Random random = new Random();

    @FXML
    public void initialize(){
        insertarPatitos();
    }

    @FXML
    private void insertarPatitos(){
        contenedorPatos.getChildren().clear();
        int num = random.nextInt(2, 7);
        int cambio = random.nextInt(0, 2);
        while (num > 0){
            ImageView imageView = new ImageView();
            Image image;
            if (cambio == 1){
                image = new Image(Aplicacion.class.getResourceAsStream("imagenes/duck1.png"), 150, 116, false, false);
                imageView.setOnMouseClicked(mouseEvent -> {
                    Image imageok = new Image(Aplicacion.class.getResourceAsStream("imagenes/duck1_ok.png"), 150,116, false, false);
                    imageView.setImage(imageok);
                });
                cambio--;
            } else {
                image = new Image(Aplicacion.class.getResourceAsStream("imagenes/duck1_i.png"), 150, 116, false, false);
                cambio++;
            }
            imageView.setImage(image);
            contenedorPatos.getChildren().add(imageView);
            num--;
        }
    }
}
