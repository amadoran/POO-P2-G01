module ec.espol.poop2g01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ec.espol.poop2g01 to javafx.fxml;
    exports ec.espol.poop2g01;
    exports ec.espol.poop2g01.controladores;
    exports ec.espol.poop2g01.modelo;
    opens ec.espol.poop2g01.controladores to javafx.fxml;
}