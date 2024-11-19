package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.VendedorDto;

import java.util.List;

public interface IAgregarVendedorControllerServices {
    List<VendedorDto> getListaVendedoresDtoTotal(VendedorDto vendedorDto);
    boolean verificarAmigo(VendedorDto vendedorDto,String cedula);
    void agregarVendedor(VendedorDto vendedorDto, VendedorDto vendedorDtoAmigo);
}
