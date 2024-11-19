package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.IAgregarProductoController;

public class AgregarProductoController implements IAgregarProductoController {
    private ModelFactory modelFactory;

    public AgregarProductoController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public boolean verificarNombreExistente(ProductoDto productoDto) {
        return modelFactory.verificarNombreExistente(productoDto);
    }

    @Override
    public boolean crearProducto(ProductoDto productoDto, VendedorDto vendedorDto) {
        return modelFactory.crearProducto(productoDto, vendedorDto);
    }
}
