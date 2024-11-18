package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.service.IVendedorControllerServices;

import java.util.List;

public class VendedorController implements IVendedorControllerServices {
    ModelFactory modelFactory;
    public VendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public VendedorDto getVendedor(String cedula) {
        return modelFactory.getVendedor(cedula);
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return modelFactory.getListaProductosDto(id);
    }
}
