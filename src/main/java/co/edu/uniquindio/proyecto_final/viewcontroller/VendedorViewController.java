package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.controller.VendedorController;
import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.Label;

import javax.swing.*;

public class VendedorViewController implements Initializable, Observer {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vendedorController = new VendedorController();
    }

    private VendedorDto vendedor;
    VendedorController vendedorController;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPaneMuro;

    @FXML
    private AnchorPane anchorPaneProductos;

    @FXML
    private AnchorPane anchorPaneVendedores;

    @FXML
    private Button buttonEliminarProducto;

    @FXML
    private Button buttonEliminarPublicacion;

    @FXML
    private Button bttnGestionarPublicacion;

    @FXML
    private Label labelName;

    @FXML
    private Button buttonLogOut;

    @FXML
    private Button buttonMisProductos;

    @FXML
    private Button buttonModificarProducto;

    @FXML
    private Button buttonModificarPublicacion;


    @FXML
    private Button buttonMuro;

    @FXML
    private Button buttonVendedores;

    @FXML
    private Button buttonReportes;

    @FXML
    private Button buttonAgregarProducto;

    @FXML
    private Button buttonAgregarPublicacion;

    @FXML
    private Button buttonAgregarVendedor;



    @FXML
    private Tab tabMuro;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabProductos;

    @FXML
    private Tab tabVendedores;

    @FXML
    private GridPane gridPaneProductos;

    @FXML
    private GridPane gridPanePublicaciones;

    @FXML
    private GridPane gridPaneVendedores;


    @FXML
    private Text txtUserName;

    @FXML
    void onReportes(ActionEvent event) {
        exportarEstadisticas(estadiasticas(),vendedor.nombre());
    }


    @FXML
    void onGestionarPublicacion(ActionEvent event) {


    }

    @FXML
    void onVendedores(ActionEvent event) throws IOException {
        tabPane.getSelectionModel().select(tabVendedores);
        mostrarVendedores();
    }

    public void mostrarVendedores() throws IOException {
        int columnas = 0;
        int filas = 0;
        gridPaneVendedores.getChildren().clear();
        List<VendedorDto> vendedores = vendedorController.getListaVendedoresDto(vendedor.cedula());
        for (VendedorDto vendedor : vendedores) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/vendedor-target-view.fxml"));
            AnchorPane anchorPane = loader.load();
            VendedorTargetViewController controller = loader.getController();
            controller.setData(vendedor);
            gridPaneVendedores.add(anchorPane, columnas, filas);
            columnas++;
            if (columnas > 2) {
                columnas = 0;
                filas++;
            }
        }
    }

    @FXML
    void onMuro(ActionEvent event) throws IOException {
        tabPane.getSelectionModel().select(tabMuro);
        mostrarPublicaciones();
    }

    @FXML
    void onProductos(ActionEvent event) throws IOException {
        tabPane.getSelectionModel().select(tabProductos);
        mostrarProductos();
    }

    @Override
    public void update() throws IOException{
        mostrarProductos();
        mostrarVendedores();
        mostrarPublicaciones();
    }

    @FXML
    void onAgregarProducto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/agregar-producto.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        AgregarProductoViewController controller = loader.getController();
        controller.setVendedor(vendedor);
        controller.addObserver(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onEliminarProducto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/eliminar-producto.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        EliminarProductoViewController controller = loader.getController();
        controller.setVendedor(vendedor);
        controller.addObserver(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onModificarProducto(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/modificar-producto.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        ModificarProductoViewController controller = loader.getController();
        controller.setVendedor(vendedor);
        controller.addObserver(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onAgregarPublicacion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/agregar-publicacion.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        AgregarPublicacionViewController controller = loader.getController();
        controller.setVendedor(vendedor);
        controller.addObserver(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }



    @FXML
    void onAgregarVendedor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/agregar-vendedor.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        AgregarVendedorViewController controller = loader.getController();
        controller.setVendedor(vendedor);
        controller.addObserver(this);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void mostrarPublicaciones() throws IOException {
        int columnas = 0;
        int filas = 0;
        gridPanePublicaciones.getChildren().clear();
        List<PublicacionDto> publicaciones = vendedorController.getListaPublicacionesDto();
        for (PublicacionDto publicacionDto : publicaciones) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/publicaciones.fxml"));
            AnchorPane anchorPane = loader.load();
            PublicacionViewController controller = loader.getController();
            controller.setData(publicacionDto);
            gridPanePublicaciones.add(anchorPane, columnas, filas);
            filas++;
        }
    }

    public void mostrarProductos() throws IOException {
        int columnas = 0;
        int filas = 0;
        gridPaneProductos.getChildren().clear();
        List<ProductoDto> productos = vendedorController.getListaProductosDto(vendedor.cedula());
        for (ProductoDto producto : productos) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/producto-view.fxml"));
            AnchorPane anchorPane = loader.load();
            ProductoViewController controller = loader.getController();
            controller.setData(producto);
            gridPaneProductos.add(anchorPane, columnas, filas);
            columnas++;
            if (columnas > 3) {
                columnas = 0;
                filas++;
            }
        }
    }

    @FXML
    void onCerrarSesion(ActionEvent event) {
        loadStage("/co/edu/uniquindio/proyecto_final/login.fxml", event);
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

    public static void exportarEstadisticas(String contenidoEstadisticas, String usuario) {
        String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String titulo = "Reporte de Estadísticas";
        String contenidoReporte = String.format("%s\nFecha de exportación: %s\nUsuario: %s\n\n%s",
                titulo, fecha, usuario, contenidoEstadisticas);
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar carpeta para guardar el reporte");
        fileChooser.setInitialFileName("reporte_estadisticas.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));
        File archivo = fileChooser.showSaveDialog(null);
        if (archivo != null) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
                writer.write(contenidoReporte);
                System.out.println("Reporte exportado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al exportar el reporte: " + e.getMessage());
            }
        } else {
            System.out.println("Operación cancelada por el usuario.");
        }
    }



    @FXML
    void onEliminarPublicacion(ActionEvent event) {

    }

    @FXML
    void onModificarPublicacion(ActionEvent event) {

    }

    public String estadiasticas(){
        String mensaje = "";
        int contador = 0;
        List<ProductoDto> productos = vendedorController.getListaProductosDto(vendedor.cedula());
        for (ProductoDto productoDto : productos) {
            contador++;
        }
        mensaje = "La cantidad de productos publicados por el vendedor " + vendedor.nombre() + " es " + contador + " productos.";
        return mensaje;
    }

    @FXML
    void initialize() {
        assert buttonReportes != null : "fx:id=\"buttonReportes\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert anchorPaneMuro != null : "fx:id=\"anchorPaneMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert anchorPaneProductos != null : "fx:id=\"anchorPaneProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert anchorPaneVendedores != null : "fx:id=\"anchorPaneVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonLogOut != null : "fx:id=\"buttonLogOut\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMisProductos != null : "fx:id=\"buttonMisProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMuro != null : "fx:id=\"buttonMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonVendedores != null : "fx:id=\"buttonVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert gridPaneProductos != null : "fx:id=\"gridProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabMuro != null : "fx:id=\"tabMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabProductos != null : "fx:id=\"tabProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabVendedores != null : "fx:id=\"tabVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";

    }

    public VendedorDto getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDto vendedor) {
        this.vendedor = vendedor;
    }


    public void setNombreScena() {
        labelName.setText(vendedor.nombre().toUpperCase());
    }
}

