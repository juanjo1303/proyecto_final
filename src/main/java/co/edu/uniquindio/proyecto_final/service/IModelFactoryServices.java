package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;

import java.util.List;

public interface IModelFactoryServices {
    String obtenerCedulaVendedor(UsuarioDto usuarioDto);
    boolean verificarCedulaExistente(VendedorDto vendedor);
    boolean verificarVendedorExistente(VendedorDto vendedorDto);
    boolean verificarCredenciales(UsuarioDto usuarioDto);
    boolean crearVendedor(VendedorDto vendedor);
    VendedorDto getVendedor(String id);
    List<ProductoDto> getListaProductosDto(String id);
}
