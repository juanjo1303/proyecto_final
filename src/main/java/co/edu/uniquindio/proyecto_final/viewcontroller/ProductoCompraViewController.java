package co.edu.uniquindio.proyecto_final.viewcontroller;

import co.edu.uniquindio.proyecto_final.controller.ProductoCompraController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Estado;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Objects;

public class ProductoCompraViewController {
    private ProductoCompraController productoCompraController;
    private VendedorDto vendedorDto;
    private ProductoDto selectedProduct;
    ObservableList<ProductoDto> productos = FXCollections.observableArrayList();

    @FXML
    private Button bttnComprar;

    @FXML
    private Button cerrarButton;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private ImageView imageProducto;

    @FXML
    private Label labelProducto;

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
    void onComprar() {
        if(verificacionFinal()){
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        int index = productos.indexOf(selectedProduct);
        if (index >= 0) {
            productos.set(index, buildDtoProducto());
        }

        tableProducto.refresh();
    }

    private boolean verificacionFinal() {
        boolean estado = false;
        if(selectedProduct != null){
            if(selectedProduct.estado().equals(Estado.PUBLICADO)){
                ProductoDto newProducto = buildDtoProducto();
                productoCompraController.actualizarProducto(newProducto,vendedorDto);
                mostrarAlertaCompra();
                estado = true;
            }else {
                mostrarAlertaNoDisponible();
            }
        }
        return estado;
    }

    private void mostrarAlertaCompra() {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Compra Exitosa");
        alerta.setHeaderText("La compra se realizó satisfactoriamente");
        alerta.setContentText("Gracias por tu compra");
        alerta.showAndWait();
    }

    private void mostrarAlertaNoDisponible() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Producto No Disponible");
        alerta.setHeaderText("El producto no está disponible");
        alerta.setContentText("Por favor seleccione otro producto");
        alerta.showAndWait();
    }

    private ProductoDto buildDtoProducto() {
        return new ProductoDto(selectedProduct.nombre(),selectedProduct.imagen(),selectedProduct.categoria(),selectedProduct.precio(),Estado.VENDIDO);
    }


    @FXML
    void initialize() {
        assert bttnComprar != null : "fx:id=\"bttnComprar\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert imageProducto != null : "fx:id=\"imageProducto\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert labelProducto != null : "fx:id=\"labelProducto\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert tableProducto != null : "fx:id=\"tableProducto\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert tcCategoria != null : "fx:id=\"tcCategoria\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert tcEstado != null : "fx:id=\"tcEstado\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        assert tcPrecio != null : "fx:id=\"tcPrecio\" was not injected: check your FXML file 'producto-compra-view.fxml'.";
        imageProducto.setFitWidth(150);
        imageProducto.setFitHeight(150);
        imageProducto.setPreserveRatio(true);
        productoCompraController = new ProductoCompraController();
        initView();
    }

    public void setVendedor(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
        labelProducto.setText("Productos de " + vendedorDto.nombre());
        cargarProductos();
    }

    public void cargarProductos() {
        obtenerProductos();
        tableProducto.getItems().clear();
        tableProducto.setItems(productos);
    }

    private void obtenerProductos() {
        productos.addAll(productoCompraController.getListaProductosDto(vendedorDto.cedula()));
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
        tableProducto.getSelectionModel().selectedItemProperty().addListener((_, _, newValue) -> {selectedProduct = newValue;
            mostrarInformacionProducto(selectedProduct);});
    }

    private void mostrarInformacionProducto(ProductoDto selectedProduct) {
        if(selectedProduct != null) {
            imageProducto.setImage(new Image(Objects.requireNonNull(getClass().getResource(selectedProduct.imagen())).toExternalForm()));
        }else {
            imageProducto.setImage(new Image(Objects.requireNonNull(getClass().getResource("/co/edu/uniquindio/images/lupa.jpg")).toExternalForm()));
        }
    }
}