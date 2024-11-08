package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.DtoVendedor;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;

public interface IRegistroControllerServices {
    boolean crearVendedor(DtoVendedor vendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarProducto(String cedula, VendedorBuilder vendedorBuilder);
}
