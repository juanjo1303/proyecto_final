package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class VendedorViewController {

@FXML
private ResourceBundle resources;

@FXML
private URL location;

@FXML
private Button buttonLogOut;

@FXML
private Button buttonMisProductos;

@FXML
private Button buttonMuro;

@FXML
private Button buttonVendedores;

@FXML
void logOut(MouseEvent event) {

}

@FXML
void misProductos(MouseEvent event) {

}

@FXML
void muro(MouseEvent event) {

}

@FXML
void vendedores(MouseEvent event) {

}

@FXML
void initialize() {
    assert buttonLogOut != null : "fx:id=\"buttonLogOut\" was not injected: check your FXML file 'vendedor-view.fxml'.";
    assert buttonMisProductos != null : "fx:id=\"buttonMisProductos\" was not injected: check your FXML file 'vendedor-view.fxml'.";
    assert buttonMuro != null : "fx:id=\"buttonMuro\" was not injected: check your FXML file 'vendedor-view.fxml'.";
    assert buttonVendedores != null : "fx:id=\"buttonVendedores\" was not injected: check your FXML file 'vendedor-view.fxml'.";

}

}

