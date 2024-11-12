package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;

import java.util.List;

public interface IVendedorControllerServices {
    VendedorDto getVendedor(String id);
    List<ProductoDto> getListaProductosDto(String id);
}