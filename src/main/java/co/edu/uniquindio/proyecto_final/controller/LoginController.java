package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.service.ILoginControllerServices;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import java.io.IOException;

public class LoginController implements ILoginControllerServices {
    private ModelFactory modelFactory;

    public LoginController(){modelFactory = ModelFactory.getInstance();}

    public boolean verificarCredenciales(UsuarioDto usuarioDto) {
        return modelFactory.verificarCredenciales(usuarioDto);
    }

    @Override
    public String obtenerCedulaVendedor(UsuarioDto usuarioDto) {
        return modelFactory.obtenerCedulaVendedor(usuarioDto);
    }
}