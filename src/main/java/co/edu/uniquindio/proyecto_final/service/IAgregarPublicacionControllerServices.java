package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;

import java.util.List;

public interface IAgregarPublicacionControllerServices {
    List<ProductoDto> getListaProductosDto(String id);
    void agregarPublicacion(PublicacionDto publicacionDto);
}
