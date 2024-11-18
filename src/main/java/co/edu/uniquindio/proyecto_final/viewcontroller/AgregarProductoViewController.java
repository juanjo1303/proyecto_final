package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import co.edu.uniquindio.proyecto_final.controller.AgregarProductoController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;


import javax.swing.*;

public class AgregarProductoViewController implements Observable {
    private AgregarProductoController agregarProductoController;
    private ProductoDto productoDto;
    private VendedorDto vendedorDto;
    private String imageUrl = "/co/edu/uniquindio/images/";
    private Set<Observer> observerSet;

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
        observerSet = new HashSet<>();
    }

    @FXML
    void onAgregar(ActionEvent event) throws IOException {
        if(validacionFinal(event)){
            Stage currentStage = (Stage) agregarButton.getScene().getWindow();
            currentStage.close();
            this.notifyObservers();
        }
    }

    private boolean validacionFinal(ActionEvent event) {
        boolean estado = false;
        if(camposVacios() == true){
            productoDto = buildDtoProducto();
            agregarProductoController.crearProducto(productoDto,vendedorDto);

            estado = true;
        } else{
            mostarAlertaDatosVacios();
        }
        return estado;
    }

    private void mostarAlertaDatosVacios() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error de registro");
        alerta.setHeaderText("Campos vacios");
        alerta.setContentText("Por favor verifica tus datos.");
        alerta.showAndWait();
    }

    private ProductoDto buildDtoProducto() {
        return new ProductoDto(nombreTextField.getText(),imageUrl,categoriaTextField.getText(), precioTextField.getText(), cbEstado.getValue());
    }

    private boolean camposVacios() {
        String nombre = nombreTextField.getText();
        String categoria = categoriaTextField.getText();
        String precio = precioTextField.getText();
        Estado estado = cbEstado.getValue();
        String image = imageUrl;

        if(nombre == null || categoria == null || precio == null || estado == null || image == null ){
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

    /*private void seleccionarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Seleccionar imagen");
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Imágenes", "png", "jpg", "jpeg"));

        int resultado = fileChooser.showOpenDialog(null);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            File archivoImagen = fileChooser.getSelectedFile();
            try {
                Image imagen = new Image(new FileInputStream(archivoImagen));
                imagenProducto.setImage(imagen);
                imageUrl = imageUrl + archivoImagen.getName();
                System.out.print(imageUrl);
            } catch (FileNotFoundException e) {
                mostrarAlertaImagenInvalida();
            }
        }
    }*/

    private void seleccionarImagen() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.jpeg");
        fileChooser.getExtensionFilters().add(extensionFilter);
        File archivoImagen = fileChooser.showOpenDialog(new Stage());
        if(archivoImagen != null){
            try {
                Image imagen = new Image(new FileInputStream(archivoImagen));
                imagenProducto.setImage(imagen);
                imageUrl = imageUrl + archivoImagen.getName();
            } catch (FileNotFoundException e) {
                mostrarAlertaImagenInvalida();
            }
        }

    }

    private void mostrarAlertaImagenInvalida() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error al seleccionar imagen");
        alerta.setHeaderText("No se pudo seleccionar imagen");
        alerta.setContentText("Por favor seleccione una imagen");
        alerta.showAndWait();
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

    @Override
    public void addObserver(Observer o) {
        observerSet.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observerSet.remove(o);
    }

    @Override
    public void notifyObservers() throws IOException {
        for (Observer observer : observerSet) {
            observer.update();
        }
    }
}
