package ec.espol.poop2g01.controladores;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modelo.Estado;
import modelo.Servicio;

public class ServiciosController {
    @FXML
    private VBox fScene;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<Servicio, String> colNombre;
    @FXML
    private TableColumn<Servicio, Integer> colDuracion;
    @FXML
    private TableColumn<Servicio, Float> colPrecio;
    @FXML
    private TableColumn<Servicio, Estado> colEstado;
    @FXML
    private Button aggBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button returnBtn;

    @FXML
    public void initialize(){
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionServicio"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("empleado"));

        tableView.getItems().setAll(Servicio.cargarServicios());
    }

    public void escenaAgregado(){
        fScene.getChildren().clear();
    }
}
