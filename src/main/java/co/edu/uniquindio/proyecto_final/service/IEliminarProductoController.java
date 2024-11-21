package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;

import java.util.List;

public interface IEliminarProductoController {
    boolean eliminarProducto(ProductoDto producto, VendedorDto vendedor);
    List<ProductoDto> getListaProductosDto(String id);
}
