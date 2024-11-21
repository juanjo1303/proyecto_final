package co.edu.uniquindio.proyecto_final.service;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.Producto;

public interface ICrudProducto {
    boolean crearProducto(Producto newProducto, VendedorDto vendedorDto);
    boolean eliminarProducto(Producto producto, String cedula);
    boolean actualizarProducto(Producto newProducto, VendedorDto vendedorDto);
    Producto getProducto(String nombre);
}
