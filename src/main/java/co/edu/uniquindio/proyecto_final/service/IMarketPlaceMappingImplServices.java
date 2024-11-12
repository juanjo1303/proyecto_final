package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.List;

public interface IMarketPlaceMappingImplServices {
    VendedorDto VendedorToVendedorDto(Vendedor vendedor);
    List<ProductoDto> ProductosToProductosDto(List<Producto> productos);
    ProductoDto ProductoToProductoDto(Producto producto);
}
