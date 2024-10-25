package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelarLoginButton;

    @FXML
    private Label contrasenaField;

    @FXML
    private Button entrarLoginButton;

    @FXML
    private Label usuarioField;

    @FXML
    void validarUsuario(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert cancelarLoginButton != null : "fx:id=\"cancelarLoginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert contrasenaField != null : "fx:id=\"contrasenaField\" was not injected: check your FXML file 'login.fxml'.";
        assert entrarLoginButton != null : "fx:id=\"entrarLoginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert usuarioField != null : "fx:id=\"usuarioField\" was not injected: check your FXML file 'login.fxml'.";

    }

}

