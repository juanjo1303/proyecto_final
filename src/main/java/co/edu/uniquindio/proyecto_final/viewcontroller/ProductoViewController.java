package co.edu.uniquindio.proyecto_final.viewcontroller;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Objects;

public class ProductoViewController {

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPrecio;

    @FXML
    private Label labelEstado;

    ProductoDto producto;

    public void setData(ProductoDto producto) {
        imagenProducto.setImage(new Image(Objects.requireNonNull(getClass().getResource(producto.imagen())).toExternalForm()));
        labelNombre.setText(producto.nombre());
        labelDescripcion.setText(producto.categoria());
        labelPrecio.setText("$" + producto.precio());
        labelEstado.setText(producto.estado().toString());
        this.producto = producto;
    }
}
