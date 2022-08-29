package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Estado;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CitasController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TableView tableView;
    @FXML
     private TableColumn  colNombre;

    @FXML
    private TableColumn colTerapista;

    @FXML
    private TableColumn colServicio;

    @FXML
    private TableColumn colFecha;

    @FXML
    private TableColumn colHora;

    @FXML
    private TableColumn colOpciones;


    public void IrACrearCitas() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("crearCitas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Creacion de Citas");
        stage.setScene(scene);
        stage.show();
    }

    public void IrARegistrarAtencion() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("registrarAtencion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Registro de Atención");
        stage.setScene(scene);
        stage.show();
    }

    public void IrAActividadesRealizadas() throws IOException {
        Stage stage = (Stage) this.anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("actividades.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Actividades Realizadas");
        stage.setScene(scene);
        stage.show();
    }

    public void irAMenu() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("menu-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }
}
