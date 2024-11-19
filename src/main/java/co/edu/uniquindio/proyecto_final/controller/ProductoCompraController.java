package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.IAgregarProductoController;
import co.edu.uniquindio.proyecto_final.service.IProductoCompraController;

import java.util.List;

public class ProductoCompraController implements IProductoCompraController {
    private ModelFactory modelFactory;

    public ProductoCompraController() {
        this.modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return modelFactory.getListaProductosDto(id);
    }

    @Override
    public void actualizarProducto(ProductoDto newProducto, VendedorDto vendedorDto) {
        modelFactory.actualizarProducto(newProducto, vendedorDto);
    }
}
