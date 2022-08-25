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
    String nombre = TextFieldNombre.getText();
    String cedula = TextFieldCedula.getText();
    String email = TextFieldCorreo.getText();
    String telefono = TextFieldTelefono.getText();
    Estado estado = ComboBox.getValue();
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("empleados.csv",true));){
        bw.newLine();
        bw.write(cedula+","+nombre+","+telefono+","+email+","+estado);
    }catch (IOException e){
        System.out.println("error");
    }
    reestablecer( TextFieldNombre,TextFieldCedula,TextFieldTelefono,TextFieldCorreo,ComboBox);
    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
    alerta.setTitle("Empleado agregado");
    alerta.setHeaderText("Su empleado ha sido agregado");
    alerta.showAndWait();

}
    private static void reestablecer(TextField c1, TextField c2, TextField c3, TextField c4, javafx.scene.control.ComboBox<Estado> c){
        c1.setText(null);
        c2.setText(null);
        c3.setText(null);
        c4.setText(null);
        c.setValue(null);
    }


}









