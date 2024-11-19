package co.edu.uniquindio.proyecto_final.controller;

import co.edu.uniquindio.proyecto_final.factory.ModelFactory;
import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;
import co.edu.uniquindio.proyecto_final.service.IAgregarVendedorControllerServices;

import java.util.List;

public class AgregarVendedorController implements IAgregarVendedorControllerServices {
    private ModelFactory modelFactory;

    public AgregarVendedorController() {
        modelFactory = ModelFactory.getInstance();
    }

    @Override
    public List<VendedorDto> getListaVendedoresDtoTotal(VendedorDto vendedorDto) {
        return modelFactory.getListaVendedoresDtoTotal(vendedorDto);
    }

    @Override
    public boolean verificarAmigo(VendedorDto vendedorDto, String cedula) {
        return modelFactory.verificarAmigo(vendedorDto, cedula);
    }

    @Override
    public void agregarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo) {
        modelFactory.agregarVendedor(vendedorDto, vendedorDtoAmigo);
    }

    @Override
    public void eliminarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo) {
        modelFactory.eliminarVendedor(vendedorDto, vendedorDtoAmigo);
    }
}
