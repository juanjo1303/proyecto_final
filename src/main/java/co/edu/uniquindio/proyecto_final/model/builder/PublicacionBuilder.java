package co.edu.uniquindio.proyecto_final.model.builder;

import co.edu.uniquindio.proyecto_final.model.Comentario;
import co.edu.uniquindio.proyecto_final.model.Producto;
import co.edu.uniquindio.proyecto_final.model.Publicacion;
import co.edu.uniquindio.proyecto_final.model.Vendedor;

import java.util.LinkedList;

public class PublicacionBuilder {
    private Vendedor vendedor;
    private Producto producto;
    private String descripcion;

    public PublicacionBuilder vendedor(Vendedor vendedor) {
        this.vendedor  = vendedor;
        return this;
    }

    public PublicacionBuilder producto(Producto producto) {
        this.producto = producto;
        return this;
    }

    public PublicacionBuilder descripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Publicacion build() {return new Publicacion(vendedor,producto,descripcion);}

}
