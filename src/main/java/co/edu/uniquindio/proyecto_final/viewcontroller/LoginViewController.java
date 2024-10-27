package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.Event;
import javafx.scene.Node;
import co.edu.uniquindio.proyecto_final.controller.LoginController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

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
    private TextField usuarioTxt;

    @FXML
    private TextField contrasenaTxt;

    @FXML
    private void iniciarSesion(ActionEvent event) {
        String usuario = usuarioTxt.getText();
        String contrasena = contrasenaTxt.getText();

        if (usuario.equals("vendedor") && contrasena.equals("1234")) {
            loadStage("/co/edu/uniquindio/proyecto_final/vendedor-view.fxml", event);
        } else {
            mostrarAlertaCredencialesInvalidas();
        }
    }

    @FXML
    private void loadStage(String url, Event event) {
        try {
            Window window = ((javafx.scene.Node) (event.getSource())).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource(url));
            Scene scene = new Scene(root);
            Stage newStage = (Stage) window;
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            new Exception("Error al cambiar de escena");
        }
    }

    private void mostrarAlertaCredencialesInvalidas() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de inicio de sesión");
        alerta.setHeaderText("Credenciales incorrectas");
        alerta.setContentText("Por favor, verifica tu usuario y contraseña.");
        alerta.showAndWait();
    }

    @FXML
    void initialize() {
        assert cancelarLoginButton != null : "fx:id=\"cancelarLoginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert contrasenaField != null : "fx:id=\"contrasenaField\" was not injected: check your FXML file 'login.fxml'.";
        assert contrasenaTxt != null : "fx:id=\"contrasenaTxt\" was not injected: check your FXML file 'login.fxml'.";
        assert entrarLoginButton != null : "fx:id=\"entrarLoginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert usuarioField != null : "fx:id=\"usuarioField\" was not injected: check your FXML file 'login.fxml'.";
        assert usuarioTxt != null : "fx:id=\"usuarioTxt\" was not injected: check your FXML file 'login.fxml'.";

    }
}