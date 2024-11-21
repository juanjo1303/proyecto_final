package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VendedorTargetViewController {
    private VendedorDto vendedorDto;

    @FXML
    private ImageView imagenVendedor;

    @FXML
    private Label labelDescripcion;

    @FXML
    private Button bttnProductos;

    @FXML
    private Label labelNombre;


    @FXML
    void onProductos() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/proyecto_final/producto-compra-view.fxml"));
        Scene scene = new Scene(loader.load(), 520,651);
        ProductoCompraViewController controller = loader.getController();
        controller.setVendedor(vendedorDto);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
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
        this.vendedorDto = vendedorDto;
    }
}
