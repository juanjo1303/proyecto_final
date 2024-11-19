package co.edu.uniquindio.proyecto_final.viewcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import co.edu.uniquindio.proyecto_final.controller.AgregarVendedorController;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.Observable;
import co.edu.uniquindio.proyecto_final.service.Observer;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class AgregarVendedorViewController implements Observable {
    private AgregarVendedorController agregarVendedorController;
    ObservableList<VendedorDto> vendedores = FXCollections.observableArrayList();
    private Set<Observer> observerSet;
    private VendedorDto selectedVendedor;
    private VendedorDto vendedorDto;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttnAgregar;

    @FXML
    private Button cerrarButton;

    @FXML
    private ImageView escudoImageView;

    @FXML
    private ImageView imageVendedor;

    @FXML
    private TableView<VendedorDto> tableVendedor;

    @FXML
    private TableColumn<VendedorDto, String> tcUsuario;

    @FXML
    private TableColumn<VendedorDto, String> tcNombre;

    @FXML
    void onAgregar(ActionEvent event) throws IOException {
        if(verificacionFinal()){
            this.notifyObservers();
        }
    }

    private boolean verificacionFinal() {
        boolean estado = false;
        if(selectedVendedor != null){
            if(verificarAmigo()){
                agregarVendedorController.agregarVendedor(vendedorDto,selectedVendedor);
                estado = true;
            }else {
                mostrarAlertaAmigoExistente();
            }
        }
        return estado;
    }

    private void mostrarAlertaAmigoExistente() {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Amigo Existente");
        alerta.setHeaderText("Ya es amigo de este vendedor");
        alerta.setContentText("Por favor seleccione otro vendedor");
        alerta.showAndWait();
    }

    private boolean verificarAmigo() {
        return agregarVendedorController.verificarAmigo(vendedorDto,selectedVendedor.cedula());
    }

    @FXML
    void onCerrar(ActionEvent event) {
        Stage currentStage = (Stage) cerrarButton.getScene().getWindow();
        currentStage.close();
    }

    @FXML
    void initialize() {
        assert bttnAgregar != null : "fx:id=\"bttnAgregar\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert cerrarButton != null : "fx:id=\"cerrarButton\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert escudoImageView != null : "fx:id=\"escudoImageView\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert imageVendedor != null : "fx:id=\"imageVendedor\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert tableVendedor != null : "fx:id=\"tableVendedor\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert tcUsuario != null : "fx:id=\"tcUsuario\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        assert tcNombre != null : "fx:id=\"tcNombre\" was not injected: check your FXML file 'agregar-vendedor.fxml'.";
        agregarVendedorController = new AgregarVendedorController();
        observerSet = new HashSet<>();
        initView();
    }

    private void initView() {
        initDataBinding();
        listenerSelection();
    }

    public void cargarVendedores() {
        obtenerVendedores();
        tableVendedor.getItems().clear();
        tableVendedor.setItems(vendedores);
    }



    private void obtenerVendedores() {
        vendedores.addAll(agregarVendedorController.getListaVendedoresDtoTotal(vendedorDto));
    }


    private void listenerSelection() {
        tableVendedor.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {selectedVendedor = newValue;});
    }

    private void initDataBinding(){
        tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        tcUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().usuario()));
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

    public void setVendedor(VendedorDto vendedorDto) {
        this.vendedorDto = vendedorDto;
        cargarVendedores();
    }
}
