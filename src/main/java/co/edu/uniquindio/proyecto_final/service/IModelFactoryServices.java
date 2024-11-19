package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.model.Producto;

import java.util.List;

public interface IModelFactoryServices {
    boolean verificarNombreExistente(ProductoDto productoDto);
    boolean actualizarProducto(ProductoDto newProducto, VendedorDto vendedorDto);
    boolean eliminarProducto(ProductoDto producto, VendedorDto vendedor);
    boolean crearProducto(ProductoDto productoDto, VendedorDto vendedorDto);
    String obtenerCedulaVendedor(UsuarioDto usuarioDto);
    boolean verificarCedulaExistente(VendedorDto vendedor);
    boolean verificarVendedorExistente(VendedorDto vendedorDto);
    boolean verificarCredenciales(UsuarioDto usuarioDto);
    boolean crearVendedor(VendedorDto vendedor);
    VendedorDto getVendedor(String id);
    List<ProductoDto> getListaProductosDto(String id);
    List<VendedorDto> getListaVendedoresDto(String id);
    List<VendedorDto> getListaVendedoresDtoTotal(VendedorDto vendedorDto);
    boolean verificarAmigo(VendedorDto vendedorDto, String cedula);
    void agregarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo);
    void eliminarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo);
    List<PublicacionDto> getListaPublicacionesDto();
    void agregarPublicacion(PublicacionDto publicacionDto);
}
