package co.edu.uniquindio.proyecto_final.mapping.mappers;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Vendedor;
import co.edu.uniquindio.proyecto_final.service.IMarketPlaceMappingImplServices;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.List;

public class MarketPlaceMappingImpl implements IMarketPlaceMappingImplServices {

    public MarketPlaceMappingImpl() {
    }


    @Override
    public Vendedor vendedorDtoToVendedor(VendedorDto vendedorDto) {
        return Vendedor.builder()
                .nombre(vendedorDto.nombre())
                .apellido(vendedorDto.apellido())
                .cedula(vendedorDto.cedula())
                .direccion(vendedorDto.direccion())
                .usuario(vendedorDto.usuario())
                .contrasena(vendedorDto.contrasena())
                .build();
    }

    @Override
    public VendedorDto VendedorToVendedorDto(Vendedor vendedor) {
        VendedorDto dto = new VendedorDto(vendedor.getNombre(), vendedor.getApellido(), vendedor.getCedula(), vendedor.getDireccion(), vendedor.getUsuario(), vendedor.getContrasena());
        return dto;
    }

    @Override
    public List<ProductoDto> ProductosToProductosDto(List<Producto> productos) {
        List<ProductoDto> productosDto = new ArrayList<>();
        for (Producto producto : productos) {
            productosDto.add(ProductoToProductoDto(producto));
        }
        return productosDto;
    }

    @Override
    public ProductoDto ProductoToProductoDto(Producto producto) {
        ProductoDto productoDto = new ProductoDto();
        productoDto.setNombre(producto.getNombre());
        productoDto.setCategoria(producto.getCategoria());
        productoDto.setPrecio(producto.getPrecio());
        productoDto.setImagen(new Image(getClass().getResource(producto.getImagen()).toString()));
        productoDto.setEstado(producto.getEstado());
        return productoDto;
    }
}
