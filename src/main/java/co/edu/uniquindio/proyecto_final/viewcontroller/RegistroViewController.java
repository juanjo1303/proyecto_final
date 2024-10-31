package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class RegistroViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField cedulaTextField;

    @FXML
    private Button cerrarButton;

    @FXML
    private TextField confirmarContrasenaField;

    @FXML
    private TextField direccionTextField;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private TextField nombreTextField;

    @FXML
    private Button registroButton;

    @FXML
    private TextField setContrasenaField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    void onCerrar(ActionEvent event) {
        loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
    }

    @FXML
    void onRegistro(ActionEvent event) {
        if (mostrarAlertaUsuario() == true){
            loadStage("/co/edu/uniquindio/proyecto_final/vendedorView.fxml", event);
        }
        else {
            loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
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

    private boolean mostrarAlertaUsuario() {
        Alert alerta = new Alert(Alert.AlertType.CONFIRMATION);
        alerta.setTitle("Registro de Usuario");
        alerta.setHeaderText("Registro de Usuario satisfactorio");
        alerta.setContentText("Bienvenido a Marketplace, ¿Desea continuar?");
        Optional<ButtonType> resultado = alerta.showAndWait();
        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    @FXML
    void initialize() {
        assert apellidoTextField != null : "fx:id=\"apellidoTextField\" was not injected: check your FXML file 'registro.fxml'.";
        assert cedulaTextField != null : "fx:id=\"cedulaTextField\" was not injected: check your FXML file 'registro.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'registro.fxml'.";
        assert confirmarContrasenaField != null : "fx:id=\"confirmarContrasenaField\" was not injected: check your FXML file 'registro.fxml'.";
        assert direccionTextField != null : "fx:id=\"direccionTextField\" was not injected: check your FXML file 'registro.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'registro.fxml'.";
        assert nombreTextField != null : "fx:id=\"nombreTextField\" was not injected: check your FXML file 'registro.fxml'.";
        assert registroButton != null : "fx:id=\"registroButton\" was not injected: check your FXML file 'registro.fxml'.";
        assert setContrasenaField != null : "fx:id=\"setContrasenaField\" was not injected: check your FXML file 'registro.fxml'.";
        assert usuarioTextField != null : "fx:id=\"usuarioTextField\" was not injected: check your FXML file 'registro.fxml'.";

    }

}
