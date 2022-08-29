package ec.espol.poop2g01.controladores;

import ec.espol.poop2g01.Aplicacion;
import ec.espol.poop2g01.modelo.Empleado;
import ec.espol.poop2g01.modelo.Servicio;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
        for(Servicio s:Servicio.cargarServicios()) {
            registroServicio.getItems().add(s);
        }

        for(Empleado e: Empleado.cargarEmpleados()){
            registroTerapista.getItems().add(e);
        }

    }

    public void CrearCita() throws IOException{
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("citas.csv",true))){
            bf.write(registroNombre.getText() + "," + registroTerapista.getValue() + ","
                    + registroServicio.getValue() + "," + registroFecha.getText() + ","
                    + registroHora.getText() + "," + registroOpciones.getValue());
        }catch(IOException e){
            System.out.println(e);
        }

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("citas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(),600,400);
        stage.setTitle("Citas");
        stage.setScene(scene);
        stage.show();
    }

    public void irAMenuDeCitas() throws IOException {
        Stage stage = (Stage) anchorPane.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("citas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Servicios");
        stage.setScene(scene);
        stage.show();
    }

}
