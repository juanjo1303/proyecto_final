package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.IModificarControllerServices;

import java.util.List;

public class ModificarProductoController implements IModificarControllerServices {
    ModelFactory modelFactory;

    public ModificarProductoController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public boolean actualizarProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        return modelFactory.actualizarProducto(productoDto,vendedorDto);
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return modelFactory.getListaProductosDto(id);
    }
}
