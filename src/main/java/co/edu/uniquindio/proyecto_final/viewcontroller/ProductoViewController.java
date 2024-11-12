package co.edu.uniquindio.proyecto_final.viewcontroller;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class ProductoViewController {

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelPrecio;
    ProductoDto producto;

    public void setData(ProductoDto producto) {
        imagenProducto.setImage(producto.getImagen());
        labelNombre.setText(producto.getNombre());
        labelDescripcion.setText(producto.categoria);
        labelPrecio.setText(producto.precio);
        this.producto = producto;
    }
}