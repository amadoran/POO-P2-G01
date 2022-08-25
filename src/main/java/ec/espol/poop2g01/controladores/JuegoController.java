package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.util.Random;


public class JuegoController {
    @FXML
    private FlowPane contenedorPatos;
    @FXML
    private ImageView siguiente;
    @FXML
    private HBox hboxAbajo;

    private final Random random = new Random();
    private static int maximo;

    private int veces = 0;
    private int correctas = 0;


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
                correctas++;
                imageView.setOnMouseClicked(mouseEvent -> {
                    Media correcto = new Media(Aplicacion.class.getResource("audio/happy.wav").toExternalForm());
                    MediaPlayer mediaPlayer = new MediaPlayer(correcto);
                    mediaPlayer.play();
                    Image imageok = new Image(Aplicacion.class.getResourceAsStream("imagenes/duck1_ok.png"), 150,116, false, false);
                    imageView.setImage(imageok);
                    correctas--;
                    if (isCorrect()){
                        siguiente.setVisible(true);
                        correctas = 0;
                    }
                    if (maximo == veces && isCorrect()){
                        hboxAbajo.getChildren().clear();
                        Button button = new Button("Terminar Juego");
                        button.setOnAction(actionEvent -> cerrarJuego());
                        hboxAbajo.getChildren().add(button);
                    }
                });
                cambio--;
            } else {
                image = new Image(Aplicacion.class.getResourceAsStream("imagenes/duck1_i.png"), 150, 116, false, false);
                imageView.setOnMouseClicked(mouseEvent -> {
                    Media media = new Media(Aplicacion.class.getResource("audio/error.wav").toExternalForm());
                    MediaPlayer mediaPlayer = new MediaPlayer(media);
                    mediaPlayer.play();
                });
                cambio++;
            }
            imageView.setImage(image);
            contenedorPatos.getChildren().add(imageView);
            num--;
        }
        siguiente.setVisible(false);
        veces++;

    }

    public static void setMaximo(int valor){
         maximo = valor;
    }

    private void cerrarJuego(){
        Stage stage = (Stage) contenedorPatos.getScene().getWindow();
        stage.close();
    }

    private boolean isCorrect(){
        return correctas == 0;
    }
}
