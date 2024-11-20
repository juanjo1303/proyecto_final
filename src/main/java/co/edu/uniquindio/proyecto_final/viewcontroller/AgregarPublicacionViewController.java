package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import co.edu.uniquindio.proyecto_final.controller.AgregarPublicacionController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AgregarPublicacionViewController implements Observable {
    private AgregarPublicacionController agregarPublicacionController;
    private ProductoDto selectedProduct;
    ObservableList<ProductoDto> productos = FXCollections.observableArrayList();
    private Set<Observer> observerSet;

    private VendedorDto vendedorDto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttnAgregar;

    @FXML
    private Button bttnEliminar;

    @FXML
    private Button bttnModificar;

    @FXML
    private TextField categoriaTxt;

    @FXML
    private TextField estadoTxt;

    @FXML
    private Button cerrarButton;

    @FXML
    private TextField descripcionTxt;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private ImageView imageProducto;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField precioTxt;

    @FXML
    private TableView<ProductoDto> tableProducto;

    @FXML
    private TableColumn<ProductoDto, String> tcCategoria;

    @FXML
    private TableColumn<ProductoDto, String> tcEstado;

    @FXML
    private TableColumn<ProductoDto, String> tcNombre;

    @FXML
    private TableColumn<ProductoDto, String> tcPrecio;

    @FXML
    void onEliminar(ActionEvent event) {

    }

    @FXML
    void onModificar(ActionEvent event) {

    }

    @FXML
    void onCerrar(ActionEvent event) {
        Stage currentStage = (Stage) cerrarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onAgregar(ActionEvent event) throws IOException {
        if(verificacionFinal()){
            this.notifyObservers();
            limpiarSeleccion();
        }
    }

    private void limpiarSeleccion() {
        tableProducto.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        nombreTxt.clear();
        categoriaTxt.clear();
        precioTxt.clear();
        estadoTxt.clear();
        descripcionTxt.clear();
        imageProducto.setImage(new Image(getClass().getResource("/co/edu/uniquindio/images/lupa.png").toExternalForm()));
    }

    private boolean verificacionFinal() {
        boolean estado = false;
        if(selectedProduct != null){
            PublicacionDto publicacionDto = buildPublicacionDto();
            agregarPublicacionController.agregarPublicacion(publicacionDto);
            estado = true;
        }
        return estado;
    }

    private PublicacionDto buildPublicacionDto() {
        return new PublicacionDto(vendedorDto,selectedProduct,descripcionTxt.getText());
    }


    @FXML
    void initialize() {
        assert bttnAgregar != null : "fx:id=\"bttnAgregar\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert categoriaTxt != null : "fx:id=\"categoriaTxt\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert descripcionTxt != null : "fx:id=\"descripcionTxt\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert imageProducto != null : "fx:id=\"imageProducto\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert nombreTxt != null : "fx:id=\"nombreTxt\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert precioTxt != null : "fx:id=\"precioTxt\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert tableProducto != null : "fx:id=\"tableProducto\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert tcCategoria != null : "fx:id=\"tcCategoria\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert tcEstado != null : "fx:id=\"tcEstado\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        assert tcPrecio != null : "fx:id=\"tcPrecio\" was not injected: check your FXML file 'agregar-publicacion.fxml'.";
        imageProducto.setFitWidth(150);
        imageProducto.setFitHeight(150);
        imageProducto.setPreserveRatio(true);
        agregarPublicacionController = new AgregarPublicacionController();
        observerSet = new HashSet<>();
        initView();
    }

    private void initView() {
        initDataBinding();
        listenerSelection();
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().precio()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().estado().toString()));
    }

    private void listenerSelection() {
        tableProducto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {selectedProduct = newValue;
            mostrarInformacionProducto(selectedProduct);});
    }

    private void mostrarInformacionProducto(ProductoDto selectedProduct) {
        if(selectedProduct != null) {
            imageProducto.setImage(new Image(getClass().getResource(selectedProduct.imagen()).toExternalForm()));
            nombreTxt.setText(selectedProduct.nombre());
            categoriaTxt.setText(selectedProduct.categoria());
            precioTxt.setText(selectedProduct.precio());
            estadoTxt.setText(selectedProduct.estado().toString());
        }
    }

    public void cargarProductos() {
        obtenerProductos();
        tableProducto.getItems().clear();
        tableProducto.setItems(productos);

    }

    private void obtenerProductos() {
        productos.addAll(agregarPublicacionController.getListaProductosDto(vendedorDto.cedula()));
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

    public void setVendedor(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
        cargarProductos();
    }

}