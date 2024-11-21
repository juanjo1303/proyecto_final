package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.service.ILoginControllerServices;

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