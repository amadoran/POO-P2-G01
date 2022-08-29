package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ec.espol.poop2g01.modelo.Servicio;
import ec.espol.poop2g01.modelo.Estado;

import java.io.IOException;
import java.util.ArrayList;

public class ServiciosController {
    @FXML
    private VBox fScene;
    @FXML
    private TableView<Servicio> tableView;
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

    private Stage stage;

    @FXML
    public void initialize(){
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombreServicio"));
        colDuracion.setCellValueFactory(new PropertyValueFactory<>("duracionServicio"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tableView.getItems().setAll(Servicio.cargarServicios());
    }

    public void escenaAgregado() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("agregarServicio-view.fxml"));
        stage = (Stage) fScene.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Agregar Servicios");
        stage.setScene(scene);
        stage.show();
    }

    public void regresarAMenu() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("menu-view.fxml"));
        stage = (Stage) fScene.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();
    }

    public void eliminarServicio(){
        ArrayList<Servicio> servicios = new ArrayList<>();
        for (Servicio servicio: tableView.getSelectionModel().getSelectedItems()){
            servicios.add(servicio);
        }
        Servicio.eliminarDelArchivo(servicios);
        tableView.getItems().removeAll();
        tableView.getItems().setAll(Servicio.cargarServicios());
    }

    public void editarServicio() throws IOException {
        EditarServicioController.setServicio(tableView.getSelectionModel().getSelectedItem());
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("editarServicios.fxml"));
        stage = (Stage) fScene.getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Editar Servicio");
        stage.setScene(scene);
        stage.show();
    }
}
