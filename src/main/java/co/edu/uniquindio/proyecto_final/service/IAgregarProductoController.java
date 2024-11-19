package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;

public interface IAgregarProductoController {
    boolean verificarNombreExistente(ProductoDto productoDto);
    boolean crearProducto(ProductoDto producto, VendedorDto vendedorDto);
}
