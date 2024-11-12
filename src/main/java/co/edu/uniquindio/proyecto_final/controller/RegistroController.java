package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;
import co.edu.uniquindio.proyecto_final.service.IRegistroControllerServices;

public class RegistroController implements IRegistroControllerServices {
    @Override
    public boolean crearVendedor(VendedorDto vendedor) {
        return false;
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
