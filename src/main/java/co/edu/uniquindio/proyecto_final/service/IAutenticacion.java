package co.edu.uniquindio.proyecto_final.service;

import co.edu.uniquindio.proyecto_final.mapping.dto.UsuarioDto;

public interface IAutenticacion {
    boolean iniciarSesion(UsuarioDto usuarioDto);
}
