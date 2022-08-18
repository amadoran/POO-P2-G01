package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Estado;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

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
    private ComboBox<Estado> estado;
    @FXML
    private Button Agregarbutt;
    @FXML
    private Button Editarbutt;
    @FXML
    private Button Eliminarbutt;
    @FXML
    private Button returnbutt;
    private Stage stage;
    @FXML
    public void initialize(){
        estado.getItems().setAll(Estado.values());
        cedula.setCellValueFactory(new PropertyValueFactory<>("cedula"));
        Nombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        Apellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));
        telefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        Correo.setCellValueFactory(new PropertyValueFactory<>("correo"));


        TableView.getItems().setAll(Empleado.cargarEmpleados());

    }
    public void agregarEmpleado() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("agregarEmpleados.fxml"));
        stage = (Stage) anchorPane.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Agregar Empleado");
        stage.setScene(scene);
        stage.show();
    }








}
