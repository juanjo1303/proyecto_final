package co.edu.uniquindio.proyecto_final.mapping.dto;

import co.edu.uniquindio.proyecto_final.model.Estado;

public record ProductoDto (String nombre, String imagen , String categoria, String precio, Estado estado) {
}
