package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.IEliminarProductoController;

import java.util.List;

public class EliminarProductoController implements IEliminarProductoController{
    private ModelFactory modelFactory;

    public EliminarProductoController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public boolean eliminarProducto(ProductoDto producto, VendedorDto vendedor) {
        return modelFactory.eliminarProducto(producto, vendedor);
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return modelFactory.getListaProductosDto(id);
    }
}
