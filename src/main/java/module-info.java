module ec.espol.poop2g1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ec.espol.poop2g1 to javafx.fxml;
    exports ec.espol.poop2g1;
}