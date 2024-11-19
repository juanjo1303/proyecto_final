package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

import co.edu.uniquindio.proyecto_final.controller.ModificarProductoController;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Estado;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ModificarProductoViewController implements Observable {
    private ModificarProductoController modificarProductoController;
    private VendedorDto vendedorDto;
    private ProductoDto selectedProduct;
    ObservableList<ProductoDto> productos = FXCollections.observableArrayList();
    private Set<Observer> observerSet;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField categoriaTxt;

    @FXML
    private TextField nombreTxt;

    @FXML
    private TextField precioTxt;

    @FXML
    private ComboBox<Estado> cbEstado;

    @FXML
    private Button bttnModificar;

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
    void onCerrar(ActionEvent event) {
        Stage currentStage = (Stage) cerrarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void onModificar(ActionEvent event) throws IOException {
        if(verificacionFinal()){
            this.notifyObservers();
            actualizarTabla();
        }
    }

    private void actualizarTabla() {
        int index = productos.indexOf(selectedProduct);
        if (index >= 0) {
            productos.set(index, buildDtoProducto());
        }

        tableProducto.refresh();
        limpiarSeleccion();

    }

    private void limpiarSeleccion() {
        tableProducto.getSelectionModel().clearSelection();
        limpiarCamposProducto();
    }

    private void limpiarCamposProducto() {
        nombreTxt.clear();
        categoriaTxt.clear();
        precioTxt.clear();
        cbEstado.setValue(null);
    }

    private boolean verificacionFinal() {
        boolean estado = false;
        if(selectedProduct != null) {
            if(verificacionPrecioValido()){
                ProductoDto newProducto = buildDtoProducto();
                modificarProductoController.actualizarProducto(newProducto,vendedorDto);
                estado = true;
            }else{
                mostrarAlertaPrecioCaracterInvalido();
            }

        }
        return estado;
    }

    private boolean verificacionPrecioValido() {
        boolean estado = true;
        String precio = precioTxt.getText();
        for(Character c : precio.toCharArray()){
            if(!Character.isDigit(c)){
                estado = false;
                break;
            }
        }
        return estado;
    }

    private void mostrarAlertaPrecioCaracterInvalido() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Precio Inválido");
        alerta.setHeaderText("El precio contiene caracteres inválidos");
        alerta.setContentText("Por favor solo escriba números");
        alerta.showAndWait();
    }

    private ProductoDto buildDtoProducto() {
        return new ProductoDto(nombreTxt.getText(),selectedProduct.imagen(),categoriaTxt.getText(), precioTxt.getText(), cbEstado.getValue());
    }

    @FXML
    void initialize() {
        assert bttnModificar != null : "fx:id=\"bttnModificar\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert imageProducto != null : "fx:id=\"imageProducto\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert tableProducto != null : "fx:id=\"tableProducto\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert tcCategoria != null : "fx:id=\"tcCategoria\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert tcEstado != null : "fx:id=\"tcEstado\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        assert tcPrecio != null : "fx:id=\"tcPrecio\" was not injected: check your FXML file 'modificar.producto.fxml'.";
        imageProducto.setFitWidth(150);
        imageProducto.setFitHeight(150);
        imageProducto.setPreserveRatio(true);
        modificarProductoController = new ModificarProductoController();
        cbEstado.getItems().addAll(Estado.values());
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
            cbEstado.setValue(selectedProduct.estado());
        }

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

    private void obtenerProductos() {
        productos.addAll(modificarProductoController.getListaProductosDto(vendedorDto.cedula()));
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
}