module co.edu.uniquindio.proyecto_final {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.proyecto_final to javafx.fxml;
    exports co.edu.uniquindio.proyecto_final;

    opens co.edu.uniquindio.proyecto_final.controller;
    exports co.edu.uniquindio.proyecto_final.controller;

    opens co.edu.uniquindio.proyecto_final.viewcontroller;
    exports co.edu.uniquindio.proyecto_final.viewcontroller;
}