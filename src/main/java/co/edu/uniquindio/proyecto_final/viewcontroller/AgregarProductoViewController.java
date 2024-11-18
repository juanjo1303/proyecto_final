package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.controller.AgregarProductoController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.swing.*;

public class AgregarProductoViewController {
    private AgregarProductoController agregarProductoController;
    private ProductoDto productoDto;
    private VendedorDto vendedorDto;

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
        agregarProductoController = new AgregarProductoController();
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
    private ImageView imagenProducto;

    @FXML
    private TextField nombreTextField;

    @FXML
    private TextField precioTextField;

    @FXML
    void onAgregar(ActionEvent event) {
        validacionFinal(event);
        Stage currentStage = (Stage) agregarButton.getScene().getWindow();
        currentStage.close();

    }

    private void validacionFinal(ActionEvent event) {
        if(camposVacios() == true){
            productoDto = buildDtoProducto();
            agregarProductoController.crearProducto(productoDto,vendedorDto);
        }
    }

    private ProductoDto buildDtoProducto() {
        return new ProductoDto(nombreTextField.getText(),null,categoriaTextField.getText(), precioTextField.getText(), cbEstado.getValue());
    }

    private boolean camposVacios() {
        String nombre = nombreTextField.getText();
        String categoria = categoriaTextField.getText();
        String precio = precioTextField.getText();
        Estado estado = cbEstado.getValue();

        if(nombre == null || categoria == null || precio == null || estado == null ){
            return false;
        }
        return true;
    }

    @FXML
    void onCerrar(ActionEvent event) {
        Stage currentStage = (Stage) agregarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onSeleccionarImagen(ActionEvent event) {
        seleccionarImagen();
    }

    private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        int resultado = fileChooser.showSaveDialog(null);
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


    public void setVendedor(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
    }
}
