module co.edu.uniquindio.poo.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires static lombok;
    requires java.desktop;

    opens co.edu.uniquindio.poo.proyecto_final to javafx.fxml;
    exports co.edu.uniquindio.poo.proyecto_final.fxml;
    exports co.edu.uniquindio.poo.proyecto_final.model;
    opens co.edu.uniquindio.poo.proyecto_final.model to javafx.fxml;
}