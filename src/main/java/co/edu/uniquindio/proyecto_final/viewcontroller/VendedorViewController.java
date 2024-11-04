package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

public class VendedorViewController {

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
    private Button buttonLogOut;

    @FXML
    private Button buttonMisProductos;

    @FXML
    private Button buttonMuro;

    @FXML
    private Button buttonVendedores;

    @FXML
    private Tab tabMuro;

    @FXML
    private TabPane tabPane;

    @FXML
    private Tab tabProductos;

    @FXML
    private Tab tabVendedores;

    @FXML
    void onVendedores(ActionEvent event) {
        tabPane.getSelectionModel().select(tabVendedores);
    }

    @FXML
    void onMuro(ActionEvent event) {
        tabPane.getSelectionModel().select(tabMuro);
    }

    @FXML
    void onProductos(ActionEvent event) {
        tabPane.getSelectionModel().select(tabProductos);
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

    @FXML
    void initialize() {
        assert anchorPaneMuro != null : "fx:id=\"anchorPaneMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert anchorPaneProductos != null : "fx:id=\"anchorPaneProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert anchorPaneVendedores != null : "fx:id=\"anchorPaneVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonLogOut != null : "fx:id=\"buttonLogOut\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMisProductos != null : "fx:id=\"buttonMisProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonMuro != null : "fx:id=\"buttonMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert buttonVendedores != null : "fx:id=\"buttonVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabMuro != null : "fx:id=\"tabMuro\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabProductos != null : "fx:id=\"tabProductos\" was not injected: check your FXML file 'vendedorView.fxml'.";
        assert tabVendedores != null : "fx:id=\"tabVendedores\" was not injected: check your FXML file 'vendedorView.fxml'.";

    }

}

