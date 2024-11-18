package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.controller.AgregarProductoController;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.model.MarketPlace;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AgregarProductoViewController {
    private AgregarProductoController agregarProductoController;

    @FXML
    void initialize() {
        assert agregarButton != null : "fx:id=\"agregarButton\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert bttnSeleccionarImagen != null : "fx:id=\"bttnSeleccionarImagen\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert categoriaTextField != null : "fx:id=\"categoriaTextField\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert cbEstado != null : "fx:id=\"cbEstado\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert nombreTextField != null : "fx:id=\"nombreTextField\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        assert precioTextField != null : "fx:id=\"precioTextField\" was not injected: check your FXML file 'agregar-producto.fxml'.";
        cbEstado.getItems().addAll(Estado.values());

    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarButton;

    @FXML
    private Button bttnSeleccionarImagen;

    @FXML
    private TextField categoriaTextField;

    @FXML
    private ComboBox<Estado> cbEstado;

    @FXML
    private Button cerrarButton;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    void onAgregar(ActionEvent event) {
        MarketPlace marketPlace = new MarketPlace();
    }

    @FXML
    void onCerrar(ActionEvent event) {
        Stage currentStage = (Stage) agregarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onSeleccionarImagen(ActionEvent event) {

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


}
