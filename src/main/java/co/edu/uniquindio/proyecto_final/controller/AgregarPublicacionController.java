package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.ProductoDto;
import co.edu.uniquindio.proyecto_final.mapping.dto.PublicacionDto;
import co.edu.uniquindio.proyecto_final.service.IAgregarPublicacionControllerServices;

import java.util.List;

public class AgregarPublicacionController implements IAgregarPublicacionControllerServices {
    private ModelFactory modelFactory;

    public AgregarPublicacionController() {
        this.modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<ProductoDto> getListaProductosDto(String id) {
        return modelFactory.getListaProductosDto(id);
    }

    @Override
    public void agregarPublicacion(PublicacionDto publicacionDto) {
        modelFactory.agregarPublicacion(publicacionDto);
    }
}
