package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;
import co.edu.uniquindio.proyecto_final.service.IRegistroControllerServices;

public class RegistroController implements IRegistroControllerServices {
    ModelFactory modelFactory;

    public RegistroController(){
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public boolean verificarVendedorExistente(VendedorDto vendedorDto) {
        return modelFactory.verificarVendedorExistente(vendedorDto);
    }

    @Override
    public boolean verificarCedulaExistente(VendedorDto vendedor) {
        return modelFactory.verificarCedulaExistente(vendedor);
    }

    @Override
    public boolean crearVendedor(VendedorDto vendedor) {
        return modelFactory.crearVendedor(vendedor);
    }

    @Override
    public boolean eliminarVendedor(String cedula) {
        return false;
    }

    @Override
    public boolean actualizarProducto(String cedula, VendedorBuilder vendedorBuilder) {
        return false;
    }
}
