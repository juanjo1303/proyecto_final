package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.DtoVendedor;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;

import java.util.List;

public interface VendedorControllerServices {
    DtoVendedor getVendedor(String id);
    List<ProductoDto> getListaProductosDto(String id);
}
