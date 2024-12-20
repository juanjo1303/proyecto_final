package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.*;
import java.util.*;

import co.edu.uniquindio.proyecto_final.controller.AgregarProductoController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class AgregarProductoViewController implements Observable {
    private AgregarProductoController agregarProductoController;
    private VendedorDto vendedorDto;
    private String imageUrl = "/co/edu/uniquindio/images/";
    private Set<Observer> observerSet;

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
    void onAgregar() throws IOException {
        if(validacionFinal()){
            Stage currentStage = (Stage) agregarButton.getScene().getWindow();
            currentStage.close();
            this.notifyObservers();
        }
    }

    private boolean validacionFinal() {
        boolean estado = false;
        if(camposVacios()){
            if(verificarPrecio()){
                if(!verificarNombre()){
                    ProductoDto productoDto = buildDtoProducto();
                    agregarProductoController.crearProducto(productoDto,vendedorDto);
                    estado = true;
                }else {
                    mostrarAlertaNombreExistente();
                }
            }else {
                mostrarAlertaPrecioCaracterInvalido();
            }
        } else{
            mostarAlertaDatosVacios();
        }
        return estado;
    }

    private void mostrarAlertaNombreExistente() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Nombre Existente");
        alerta.setHeaderText("El nombre ya existe");
        alerta.setContentText("Por favor escriba otro nombre");
        alerta.showAndWait();
    }

    private boolean verificarNombre() {
        ProductoDto newProducto = buildDtoProducto();
        return  agregarProductoController.verificarNombreExistente(newProducto);
    }

    private void mostrarAlertaPrecioCaracterInvalido() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Precio Inválido");
        alerta.setHeaderText("El precio contiene caracteres inválidos");
        alerta.setContentText("Por favor solo escriba números");
        alerta.showAndWait();
    }

    private boolean verificarPrecio() {
        boolean estado = true;
        String precio = precioTextField.getText();
        for(Character c : precio.toCharArray()){
            if(!Character.isDigit(c)){
                estado = false;
                break;
            }
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

        return !Objects.equals(nombre, "") && !Objects.equals(categoria, "") && !Objects.equals(precio, "") && estado != null && !Objects.equals(image, "/co/edu/uniquindio/images/");
    }

    @FXML
    void onCerrar() {
        Stage currentStage = (Stage) agregarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onSeleccionarImagen() {
        seleccionarImagen();
    }

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

    public VendedorDto getVendedor() {
        return vendedorDto;
    }
}
