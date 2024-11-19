package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class PublicacionViewController {
    private VendedorDto vendedorDto;
    ProductoDto producto;
    PublicacionDto publicacionDto;

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
    private Button btnVendedor;

    @FXML
    private Label labelNumLikes;

    @FXML
    private Label labelPrecio;



    @FXML
    void onDarLike(ActionEvent event) {
        int numLikes = Integer.parseInt(labelNumLikes.getText());
        numLikes++;
        labelNumLikes.setText(String.valueOf(numLikes));
    }

    public void setData(PublicacionDto publicacionDto) {
        imagenProducto.setImage(new Image(getClass().getResource(publicacionDto.producto().imagen()).toExternalForm()));
        labelNombre.setText(publicacionDto.producto().nombre());
        labelDescripcion.setText(publicacionDto.descripcion());
        labelPrecio.setText("$" + publicacionDto.producto().precio());
        labelEstado.setText(publicacionDto.producto().estado().toString());
        btnVendedor.setText(publicacionDto.vendedor().nombre());
        this.publicacionDto = publicacionDto;
    }

    @FXML
    void onVendedor(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/producto-compra-view.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        ProductoCompraViewController controller = loader.getController();
        controller.setVendedor(publicacionDto.vendedor());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }
}

