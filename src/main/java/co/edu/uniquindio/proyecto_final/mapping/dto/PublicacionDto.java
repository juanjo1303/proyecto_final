package co.edu.uniquindio.proyecto_final.mapping.dto;

import co.edu.uniquindio.proyecto_final.model.Comentario;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.LinkedList;

public record PublicacionDto (VendedorDto vendedor, ProductoDto producto, String descripcion){
}
