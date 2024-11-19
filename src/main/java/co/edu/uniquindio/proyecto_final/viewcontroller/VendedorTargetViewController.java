package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;

public class VendedorTargetViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView imagenVendedor;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Button bttnProductos;

    @FXML
    private Label labelNombre;

    @FXML
    void onProductos(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert imagenVendedor != null : "fx:id=\"imagenVendedor\" was not injected: check your FXML file 'vendedor-target-view.fxml'.";
        assert labelDescripcion != null : "fx:id=\"labelDescripcion\" was not injected: check your FXML file 'vendedor-target-view.fxml'.";
        assert labelNombre != null : "fx:id=\"labelNombre\" was not injected: check your FXML file 'vendedor-target-view.fxml'.";
        assert bttnProductos != null : "fx:id=\"bttnProductos\" was not injected: check your FXML file 'vendedor-target-view.fxml'.";

    }

    public void setData(VendedorDto vendedorDto) {
        labelNombre.setText(vendedorDto.nombre());
        labelDescripcion.setText(vendedorDto.usuario());
    }
}
