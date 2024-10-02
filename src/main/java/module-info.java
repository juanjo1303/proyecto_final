module co.edu.uniquindio.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyecto_final to javafx.fxml;
    exports co.edu.uniquindio.proyecto_final;
}