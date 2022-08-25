package ec.espol.poop2g01.controladores;

import javafx.fxml.FXML;
import javafx.scene.layout.*;


import javafx.scene.image.ImageView;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Stack;

public class JuegoController {


    public void InsertarImagenFlecha() throws Exception{

        FileInputStream input = new FileInputStream("ec.espol.poop2g01/imagenes/derecha.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);


    }
}
