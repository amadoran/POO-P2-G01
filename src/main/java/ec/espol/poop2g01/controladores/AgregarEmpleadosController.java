package ec.espol.poop2g01.controladores;


import ec.espol.poop2g01.modelo.Estado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class AgregarEmpleadosController {
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private VBox Vbox;
    @FXML
    private TextField TextFieldCedula;
    @FXML
    private TextField TextFieldNombre;
    @FXML
    private TextField TextFieldApellido;
    @FXML
    private TextField TextFieldTelefono;
    @FXML
    private TextField TextFieldCorreo;
    @FXML
    private ComboBox<Estado> ComboBox;
    @FXML
    private Button Agregarbutt;
    @FXML
    private Button Cancelarbutt;
    private Stage stage;


    public void initialize(){
        ComboBox.getItems().setAll(Estado.values());

    }
public void agregandoEmpleado(){
    BufferedWriter br;
    FileWriter fr;
    try {
        fr = new FileWriter("src/main/resources/ec/espol/poop2g01/archivos/empleados.dat");
        br=new BufferedWriter(fr);
        br.write(TextFieldCedula.getAccessibleText()+","+TextFieldNombre.getAccessibleText()+","+TextFieldApellido.getAccessibleText()
        +","+TextFieldCorreo.getAccessibleText()+","+TextFieldTelefono.getAccessibleText());
        br.close();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Alerta");
        alert.setHeaderText("Su empleado ha sido agregado.");
        alert.setContentText("Click \"OK\" para confirmar.");
    } catch (FileNotFoundException e){
        e.printStackTrace();
    }catch (IOException e){
        e.printStackTrace();

    }catch (Exception e){
        System.out.println("Excepcion general encontrada");

    }

    }

}









