package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PublicacionViewController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bottonLike;

    @FXML
    private ImageView imagenProducto;

    @FXML
    private Label labelComentario;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Label labelEstado;

    @FXML
    private Label labelNombre;

    @FXML
    private Label labelNumLikes;

    @FXML
    private Label labelPrecio;

    ProductoDto producto;

    @FXML
    void onDarLike(ActionEvent event) {
        int numLikes = Integer.parseInt(labelNumLikes.getText());
        numLikes++;
        labelNumLikes.setText(String.valueOf(numLikes));
    }

    public void setData(ProductoDto producto) {
        imagenProducto.setImage(new Image(getClass().getResource(producto.imagen()).toExternalForm()));
        labelNombre.setText(producto.nombre());
        labelDescripcion.setText(producto.categoria());
        labelPrecio.setText("$" + producto.precio());
        labelEstado.setText(producto.estado().toString());
        this.producto = producto;
    }
}

