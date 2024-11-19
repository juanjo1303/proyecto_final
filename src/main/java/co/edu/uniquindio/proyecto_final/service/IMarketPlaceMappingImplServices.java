package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Publicacion;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.LinkedList;
import java.util.List;

public interface IMarketPlaceMappingImplServices {
    Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto);
    VendedorDto VendedorToVendedorDto(Vendedor vendedor);
    List<ProductoDto> ProductosToProductosDto(List<Producto> productos);
    ProductoDto ProductoToProductoDto(Producto producto);
    Producto productoDtoToProducto(ProductoDto productoDto);
    List<PublicacionDto> publicacionesToPublicacionesDto(LinkedList<Publicacion> publicaciones);
    List<VendedorDto> vendedoresToVendedoresDto(LinkedList<Vendedor> vendedores);
    PublicacionDto publicacionToPublicacionDto(Publicacion publicacion);
}
