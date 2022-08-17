package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
public class EmpleadosController {

    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox Vbox;
    @FXML
    private FlowPane FlowPane;
    @FXML
    private TableView TableView;
    @FXML
    private TableColumn<Empleado, Integer> cedula;
    @FXML
    private TableColumn<Empleado, String> Nombre;
    @FXML
    private TableColumn<Empleado, String> Apellido;
    @FXML
    private TableColumn<Empleado, Integer> telefono;
    @FXML
    private TableColumn<Empleado, String> Correo;
    @FXML
    private ComboBox<Estado> Estado;
    @FXML
    private Button Agregarbutt;
    @FXML
    private Button Editarbutt;
    @FXML
    private Button Eliminarbutt;
    @FXML
    private Button returnbutt;
    @FXML
    public void initialize(){
        TableView.getItems().setAll(Empleado.cargarEmpleados());

    }







}
