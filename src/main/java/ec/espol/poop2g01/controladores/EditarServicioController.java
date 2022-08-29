package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Estado;
import ec.espol.poop2g01.modelo.Servicio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class EditarServicioController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField txtFNombre;
    @FXML
    private Spinner<Integer> spinDuracion;
    @FXML
    private Spinner<Double> spinPrecio;
    @FXML
    private ComboBox<Estado> cmbEstado;
    @FXML
    private ComboBox<Empleado> cmbEmpleado;

    private static Servicio servicioSeleccionado;

    @FXML
    public void initialize(){
        SpinnerValueFactory<Integer> valueFactoryDuracion = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 480);
        SpinnerValueFactory<Double> valueFactoryPrecio = new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 100.0);
        valueFactoryDuracion.setValue(servicioSeleccionado.getDuracionServicio());
        valueFactoryPrecio.setValue((double) servicioSeleccionado.getPrecio());
        spinDuracion.setValueFactory(valueFactoryDuracion);
        spinPrecio.setValueFactory(valueFactoryPrecio);
        cmbEstado.getItems().setAll(Estado.values());
        cmbEstado.setValue(servicioSeleccionado.getEstado());
        cmbEmpleado.getItems().setAll(Empleado.cargarEmpleados());
        cmbEmpleado.setValue(servicioSeleccionado.getEmpleado());
        txtFNombre.setText(servicioSeleccionado.getNombreServicio());
    }

    public static void setServicio(Servicio servicio){
        servicioSeleccionado = servicio;
    }
    @FXML
    private void editar() throws IOException {
        if (txtFNombre.getText().trim().equals("") || spinDuracion.getValue() == null || spinPrecio.getValue() == null
                || cmbEmpleado.getValue() == null || cmbEstado.getValue() == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Ha habido un problema");
            alert.setContentText("No has ingresado uno o varios valores");
            alert.show();
            return;
        }

        Servicio.editarArchivo(servicioSeleccionado, new Servicio(txtFNombre.getText(), spinDuracion.getValue(),
                spinDuracion.getValue().floatValue(), cmbEstado.getValue(), cmbEmpleado.getValue()));
        regresarAServicios();
    }

    @FXML
    private void regresarAServicios() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("servicios-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }
}
