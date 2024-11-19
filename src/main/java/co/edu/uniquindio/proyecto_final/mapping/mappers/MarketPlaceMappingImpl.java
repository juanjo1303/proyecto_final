package co.edu.uniquindio.proyecto_final.mapping.mappers;

import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Publicacion;
import co.edu.uniquindio.proyecto_final.model.Vendedor;
import co.edu.uniquindio.proyecto_final.model.builder.ProductoBuilder;
import co.edu.uniquindio.proyecto_final.service.IMarketPlaceMappingImplServices;
import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.LinkedList;
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
        ProductoDto productoDto = new ProductoDto(producto.getNombre(), producto.getImagen() ,producto.getCategoria(),producto.getPrecio(),producto.getEstado() );
        return productoDto;
    }

    @Override
    public Producto productoDtoToProducto(ProductoDto productoDto) {
        return Producto.builder()
                .nombre(productoDto.nombre())
                .imagen(productoDto.imagen())
                .categoria(productoDto.categoria())
                .precio(productoDto.precio())
                .estado(productoDto.estado())
                .build();
    }

    @Override
    public List<PublicacionDto> publicacionesToPublicacionesDto(LinkedList<Publicacion> publicaciones) {
        List<PublicacionDto> publicacionesDto = new ArrayList<>();
        for (Publicacion publicacion : publicaciones) {
            publicacionesDto.add(publicacionToPublicacionDto(publicacion));
        }
        return publicacionesDto;
    }

    @Override
    public PublicacionDto publicacionToPublicacionDto(Publicacion publicacion) {
        return new PublicacionDto(VendedorToVendedorDto(publicacion.getVendedor()),ProductoToProductoDto(publicacion.getProducto()),publicacion.getDescripcion());
    }

    public Publicacion publicacionDtoToPublicacion(PublicacionDto publicacionDto) {
        return Publicacion.builder()
                .vendedor(vendedorDtoToVendedor(publicacionDto.vendedor()))
                .producto(productoDtoToProducto(publicacionDto.producto()))
                .descripcion(publicacionDto.descripcion())
                .build();
    }

    public List<VendedorDto> vendedoresToVendedoresDto(LinkedList<Vendedor> vendedores) {
        List<VendedorDto> vendedoresDto = new ArrayList<>();
        for (Vendedor vendedor : vendedores) {
            vendedoresDto.add(VendedorToVendedorDto(vendedor));
        }
        return vendedoresDto;
    }
}
