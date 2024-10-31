package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;

public class VendedorViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Button buttonMisProductos;

    @FXML
    private Button buttonMuro;

    @FXML
    private Button buttonVendedores;

    @FXML
    void misProductos(ActionEvent event) {

    }

    @FXML
    void muro(ActionEvent event) {

    }

    @FXML
    void onCerrarSesion(ActionEvent event) {
        loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
    }

    @FXML
    void vendedores(ActionEvent event) {

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

    @FXML
    void initialize() {
        assert buttonLogOut != null : "fx:id=\"buttonLogOut\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMisProductos != null : "fx:id=\"buttonMisProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMuro != null : "fx:id=\"buttonMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonVendedores != null : "fx:id=\"buttonVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";

    }

}

