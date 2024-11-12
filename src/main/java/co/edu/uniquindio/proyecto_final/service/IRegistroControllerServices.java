package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.model.builder.VendedorBuilder;

public interface IRegistroControllerServices {
    boolean crearVendedor(VendedorDto vendedor);
    boolean eliminarVendedor(String cedula);
    boolean actualizarProducto(String cedula, VendedorBuilder vendedorBuilder);
}
