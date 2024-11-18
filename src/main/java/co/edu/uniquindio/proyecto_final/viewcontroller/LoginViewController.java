package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.controller.LoginController;
import co.edu.uniquindio.proyecto_final.controller.VendedorController;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import javafx.event.Event;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginViewController implements Initializable{
    private LoginController loginController;
    private UsuarioDto usuarioDto;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert contrasenaField != null : "fx:id=\"contrasenaField\" was not injected: check your FXML file 'login.fxml'.";
        assert contrasenaTxt != null : "fx:id=\"contrasenaTxt\" was not injected: check your FXML file 'login.fxml'.";
        assert entrarLoginButton != null : "fx:id=\"entrarLoginButton\" was not injected: check your FXML file 'login.fxml'.";
        assert usuarioField != null : "fx:id=\"usuarioField\" was not injected: check your FXML file 'login.fxml'.";
        assert usuarioTxt != null : "fx:id=\"usuarioTxt\" was not injected: check your FXML file 'login.fxml'.";
        vendedorController = new VendedorController();
        loginController = new LoginController();
    }
    VendedorController vendedorController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button entrarLoginButton;

    @FXML
    private Button registroButton;

    @FXML
    private Label contrasenaField;

    @FXML
    private Label usuarioField;

    @FXML
    private TextField usuarioTxt;

    @FXML
    private TextField contrasenaTxt;

    @FXML
    private void onIniciarSesion(ActionEvent event) throws IOException {
        String usuario = usuarioTxt.getText();
        String contrasena = contrasenaTxt.getText();
        UsuarioDto usuarioDto1 = new UsuarioDto(usuario,contrasena);
        String cedula = obtenerCedulaVendedor(usuarioDto1);

        if (loginController.verificarCredenciales(usuarioDto1)){

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/vendedorView.fxml"));
            Scene scene = new Scene(loader.load());
            VendedorViewController controller = loader.getController();
            controller.setVendedor(vendedorController.getVendedor(cedula));
            Stage currentStage = (Stage) registroButton.getScene().getWindow();
            currentStage.close();
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        } else {
            mostrarAlertaCredencialesInvalidas();
        }
    }

    private String obtenerCedulaVendedor(UsuarioDto usuarioDto1) {
        return loginController.obtenerCedulaVendedor(usuarioDto1);
    }

    @FXML
    void onResgistrarse(ActionEvent event) {
        loadStage("/co/edu/uniquindio/proyecto_final/registro.fxml", event);
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
}