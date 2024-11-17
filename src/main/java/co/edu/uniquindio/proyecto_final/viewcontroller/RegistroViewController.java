package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.controller.RegistroController;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
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
    private RegistroController registroController;
    private VendedorDto vendedor;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private TextField apellidoTextField;

    @FXML
    private TextField cedulaTextField;

    @FXML
    private TextField confirmarContrasenaField;

    @FXML
    private TextField direccionTextField;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField setContrasenaField;

    @FXML
    private TextField usuarioTextField;

    @FXML
    private Button registroButton;

    @FXML
    private Button cerrarButton;

    @FXML
    void onCerrar(ActionEvent event) {
        loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
    }

    @FXML
    void onRegistro(ActionEvent event) {
        validacionFinal(event);
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

    private void validacionFinal(Event event) {
        if (camposVacios() == false){
            if(contrasenaIguales() == true){
                if(verificarVendedorExistente() == true) {
                    confirmacion(event);
                    vendedor = buildDtoVendedor();
                    registroController.crearVendedor(vendedor);
                }
                else{
                    alertaVendedorExistente();
                }
            }

            else{
                alertaContrasena();
            }
        }
        else{
            alertaCamposVacios();
        }
    }

    private void alertaVendedorExistente() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Vendedor Existente");
        alerta.setHeaderText("El usuario ya existe");
        alerta.setContentText("Por favor ingresa otro usuario");
        alerta.showAndWait();
    }

    private VendedorDto buildDtoVendedor() {
        return new VendedorDto(nombreTextField.getText(),apellidoTextField.getText(),cedulaTextField.getText(),direccionTextField.getText(),usuarioTextField.getText(),setContrasenaField.getText());
    }

    private boolean verificarVendedorExistente(){
        vendedor = buildDtoVendedor();
        return registroController.verificarVendedorExistente(vendedor);
    }

    private boolean camposVacios(){

        String nombre = nombreTextField.getText();
        String apellido = apellidoTextField.getText();
        String cedula = cedulaTextField.getText();
        String direccion = direccionTextField.getText();
        String usuario = usuarioTextField.getText();
        String contrasena = setContrasenaField.getText();
        String confirmacionContrasena = confirmarContrasenaField.getText();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty() ||
                direccion.isEmpty() || usuario.isEmpty() || contrasena.isEmpty() ||
                confirmacionContrasena.isEmpty()) {
            return true;

        }
        else {
            return false;
        }
    }

    private boolean contrasenaIguales(){
        String contrasena = setContrasenaField.getText();
        String confirmacionContrasena = confirmarContrasenaField.getText();

        if(contrasena.equals(confirmacionContrasena)){
            return true;
        }
        else{
            return false;
        }
    }

    private void confirmacion(Event event){
        if (mostrarAlertaUsuario() == true){
            loadStage("/co/edu/uniquindio/proyecto_final/vendedorView.fxml", event);
        }
        else {
            loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
        }
    }

    private void alertaContrasena(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Contraseña incorrecta");
        alerta.setHeaderText("La contraseña y la confirmacion son diferentes.");
        alerta.setContentText("Por favor verifica tu contraseña.");
        alerta.showAndWait();
    }

    private void alertaCamposVacios(){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de registro");
        alerta.setHeaderText("Campos vacios");
        alerta.setContentText("Por favor verifica tus datos.");
        alerta.showAndWait();
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
        registroController = new RegistroController();
    }

}
