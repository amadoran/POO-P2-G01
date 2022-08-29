package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.modelo.Servicio;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.StringConverter;

public class CreacionCitasController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField registroNombre;

    @FXML
    private TextField registroFecha;

    @FXML
    private TextField registroHora;

    @FXML
    private ComboBox registroTerapista;

    @FXML
    private ComboBox registroServicio;

    @FXML
    private ComboBox registroOpciones;


    @FXML
    public void initialize(){
        registroServicio.getItems().add(Servicio.cargarServicios());

        registroServicio.setConverter(new StringConverter() {
            @Override
            public String toString(Servicio s) {
                return s.getNombreServicio();
            }

            @Override
            public Object fromString(String s) {
                return null;
            }
        });
    }
}
