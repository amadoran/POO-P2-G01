package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.modelo.Cliente;
import ec.espol.poop2g01.modelo.Representante;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClientesController {
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private VBox Vbox;
    @FXML
    private javafx.scene.control.TableView tabla;
    @FXML
    private TableColumn<Cliente, Integer> tablaCedula;
    @FXML
    private TableColumn<Cliente, String> tablaNombre;
    @FXML
    private TableColumn<Cliente, String> tablaApellido;
    @FXML
    private TableColumn<Cliente, Integer> tablaTelefono;
    @FXML
    private TableColumn<Cliente, String> tablaCorreo;
    @FXML
    private TableColumn<Representante, String> tablaRepresentante;
    @FXML
    private Button Agregarclientebttn;
    @FXML
    private Button Editarclientebttn;
    @FXML
    private Button Eliminarclientebttn;
    @FXML
    private Button Regresaralmenubttn;
    private Stage stage;
    @FXML
    public void initialize(){
        tablaCedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        tablaNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tablaApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        tablaTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tablaCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));
        tablaRepresentante.setCellValueFactory(new PropertyValueFactory<>("Representante"));

        tabla.getItems().setAll(Cliente.cargarClientes());

    }
}
