package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Estado;
import ec.espol.poop2g01.modelo.Servicio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class AgregarServicioController {
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

    @FXML
    public void initialize(){
        SpinnerValueFactory<Integer> valueFactoryDuracion = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 480);
        SpinnerValueFactory<Double> valueFactoryPrecio = new SpinnerValueFactory.DoubleSpinnerValueFactory(1.0, 100.0);
        valueFactoryDuracion.setValue(1);
        valueFactoryPrecio.setValue(1.0);

        spinDuracion.setValueFactory(valueFactoryDuracion);
        spinPrecio.setValueFactory(valueFactoryPrecio);
        cmbEstado.getItems().setAll(Estado.values());
        cmbEmpleado.getItems().setAll(Empleado.cargarEmpleados());
    }

    @FXML
    private void crearServicio() throws IOException {
        ObjectOutputStream obs = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Aplicacion.class.getResource("archivos/servicios.dat").getPath()))){
            ArrayList<Servicio> servicios = (ArrayList<Servicio>) ois.readObject();
            String nombre = txtFNombre.getText();
            int duracion = spinDuracion.getValue();
            float precio = spinPrecio.getValue().floatValue();
            Estado estado = cmbEstado.getValue();
            Empleado empleado = cmbEmpleado.getValue();
            servicios.add(new Servicio(nombre, duracion, precio, estado, empleado));
            obs = new ObjectOutputStream(new FileOutputStream(Aplicacion.class.getResource("archivos/servicios.dat").getPath()));
            obs.writeObject(servicios);
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                obs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        regresarAServicios();
    }

    private void regresarAServicios() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("servicios-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }
}
