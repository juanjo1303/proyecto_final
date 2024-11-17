package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;

public interface ILoginControllerServices {
    boolean verificarCredenciales(UsuarioDto usuarioDto);
}
