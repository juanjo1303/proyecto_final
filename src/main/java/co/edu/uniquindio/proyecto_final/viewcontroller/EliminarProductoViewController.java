package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import co.edu.uniquindio.proyecto_final.controller.EliminarProductoController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class EliminarProductoViewController implements Observable {
    private EliminarProductoController eliminarProductoController;
    private VendedorDto vendedorDto;
    private ProductoDto selectedProduct;
    ObservableList<ProductoDto> productos = FXCollections.observableArrayList();
    private Set<Observer> observerSet;

    @FXML
    private Button bttnEliminar;

    @FXML
    private Button cerrarButton;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private ImageView imageProducto;

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
    void onCerrar() {
        Stage currentStage = (Stage) cerrarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onEliminar() throws IOException {
        validacionFinal();
    }

    private void validacionFinal() throws IOException {
        if(selectedProduct != null){
            eliminarProductoController.eliminarProducto(selectedProduct,vendedorDto);
            productos.remove(selectedProduct);
            this.notifyObservers();
        }
    }

    @FXML
    void initialize() {
        assert bttnEliminar != null : "fx:id=\"bttnEliminar\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert imageProducto != null : "fx:id=\"imageProducto\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert tableProducto != null : "fx:id=\"tableProducto\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert tcCategoria != null : "fx:id=\"tcCategoria\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert tcEstado != null : "fx:id=\"tcEstado\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        assert tcPrecio != null : "fx:id=\"tcPrecio\" was not injected: check your FXML file 'eliminar-producto.fxml'.";
        imageProducto.setFitWidth(150);
        imageProducto.setFitHeight(150);
        imageProducto.setPreserveRatio(true);
        eliminarProductoController = new EliminarProductoController();
        observerSet = new HashSet<>();
        initView();
    }


    private void listenerSelection() {
        tableProducto.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> {selectedProduct = newValue;
            mostrarInformacionProducto(selectedProduct);});
    }

    private void mostrarInformacionProducto(ProductoDto selectedProduct) {
        imageProducto.setImage(new Image(Objects.requireNonNull(getClass().getResource(selectedProduct.imagen())).toExternalForm()));
    }

    private void initView() {
        initDataBinding();
        listenerSelection();
    }

    private void obtenerProductos() {
        productos.addAll(eliminarProductoController.getListaProductosDto(vendedorDto.cedula()));
    }

    private void initDataBinding() {
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcCategoria.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().categoria()));
        tcPrecio.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().precio()));
        tcEstado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().estado().toString()));
    }

    public void cargarProductos() {
        obtenerProductos();
        tableProducto.getItems().clear();
        tableProducto.setItems(productos);
    }

    public void setVendedor(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
        cargarProductos();
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